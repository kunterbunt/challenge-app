package sebastians.challenge.adapter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import sebastians.challenge.R;
import sebastians.challenge.data.ImagePath;
import sebastians.challenge.tools.PhotoManager;
import sebastians.challenge.tools.ViewDimensionGetter;

/**
 * Created by kunterbunt on 14.06.15.
 */
public class ViewPagerImageAdapter extends PagerAdapter {

    public static final String LOG_TAG = "ViewPagerImageAdapter";

    private Animator mAnimator;
    private int mAnimationDuration;
    private ImageView mExpandedImageView = null;
    private View mContainerLayout, mExpandedImageViewOverlay;
    private ActionBar mActionBar = null;

    private List<ImagePath> mImagePaths;
    private List<View> mViews;
    private Context mContext;
    private ImageView.ScaleType mScaleType;
    private int mTargetWidth = 0, mTargetHeight = 0;
    final private ViewPager mViewPager;
    private boolean needsToRefresh;

    public ViewPagerImageAdapter(Context context, ViewPager viewPager) {
        mContext = context;
        mImagePaths = new ArrayList<>();
        mViews = new ArrayList<>();
        mScaleType = ImageView.ScaleType.CENTER_CROP;
        mViewPager = viewPager;
        needsToRefresh = false;
        new ViewDimensionGetter(viewPager) {
            @Override
            public void sizeWasSet(int width, int height) {
                setTargetSize(width, height);
            }
        };
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public int getCount() {
        return mViews.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        final View view = mViews.get(position);
        // Set up animation click event.
        if (mExpandedImageView != null) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    zoomImage(view, mImagePaths.get(position));
                }
            });
        }
        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mViews.get(position));
    }

    @Override
    public int getItemPosition(Object object) {
        int index = mViews.indexOf(object);
        if (needsToRefresh || index == -1) {
            needsToRefresh = false;
            return POSITION_NONE;
        } else
            return index;
    }

    /**
     * Change the scale type used to show the images.
     * @param scaleType
     */
    public void setScaleType(ImageView.ScaleType scaleType) {
        this.mScaleType = scaleType;
    }

    public int add(final ImagePath path) {
        final ImageView imageView = new ImageView(mContext);
        imageView.setScaleType(mScaleType);
        if (mTargetHeight <= 0 || mTargetWidth <= 0) {
            PhotoManager.setFullBitmap(path, imageView);
        } else
            PhotoManager.setFittingBitmap(path, imageView, mTargetWidth, mTargetHeight);

        mImagePaths.add(path);
        mViews.add(imageView);
        return mViews.size() - 1;
    }

    public int add(List<ImagePath> paths) {
        int position = 0;
        for (ImagePath path : paths)
            position = add(path);
        return position;
    }

    public int remove(ImagePath path) {
        return remove(mImagePaths.indexOf(path));
    }
    public int remove(int position) {
        mViewPager.setAdapter(null);
        mImagePaths.remove(position);
        mViews.remove(position);
        mViewPager.setAdapter(this);
        return position;
    }

    public void clear() {
        mViewPager.setAdapter(null);
        mImagePaths.clear();
        mViews.clear();
        mViewPager.setAdapter(this);
    }

    public List<ImagePath> getImagePaths() {
        return mImagePaths;
    }

    /**
     * Set target width and height to tell the adapter to downsample images to fit the required dimensions.
     * Good for memory, y'know.
     * @param width
     * @param height
     */
    public void setTargetSize(int width, int height) {
        mTargetWidth = width;
        mTargetHeight = height;
    }

    public int getTargetWidth() {
        return mTargetWidth;
    }

    public int getTargetHeight() {
        return mTargetHeight;
    }

    public ViewPager getViewPager() {
        return mViewPager;
    }

    /**
     * Your layout needs two additional views:
     * 1) An ImageView that is set to INVISIBLE with a size to cover the whole screen
     * 2) A View that is also INVISIBLE that has a semi-transparent background.
     * The ImageView needs to be on top of the background View.
     * @param rootView The same view that is inflated during creation. After creation use getView() to get it.
     * @param actionBar If you also want to hide the action bar, pass it on. Otherwise leave this null.
     */
    public void setUpForZoomAnimation(View rootView, @Nullable ActionBar actionBar) {
        mAnimationDuration = mContext.getResources().getInteger(android.R.integer.config_shortAnimTime);
        mExpandedImageView = (ImageView) rootView.findViewById(R.id.expanded_image);
        mContainerLayout = rootView;
        mExpandedImageViewOverlay = rootView.findViewById(R.id.expanded_image_overlay);
        if (mExpandedImageView == null || mExpandedImageViewOverlay == null || mContainerLayout == null)
            throw new IllegalArgumentException("You need to follow the instructions of setupForZoomAnimation!");
        mActionBar = actionBar;
    }

    private void zoomImage(final View originalView, ImagePath path) {
        // Cancel current animation and start this one.
        if (mAnimator != null)
            mAnimator.cancel();

        // Load zoomed-in image.
        mExpandedImageView.setImageBitmap(PhotoManager.getFullBitmap(path));

        // Calculate starting and ending bounds for zoomed-in image.
        final Rect startBounds = new Rect();
        final Rect finalBounds = new Rect();
        final Point globalOffset = new Point();

        originalView.getGlobalVisibleRect(startBounds);
        mContainerLayout.getGlobalVisibleRect(finalBounds, globalOffset);
        startBounds.offset(-globalOffset.x, -globalOffset.y);
        finalBounds.offset(-globalOffset.x, -globalOffset.y);

        float startScale;
        if ((float) finalBounds.width() / finalBounds.height()
                > (float) startBounds.width() / startBounds.height()) {
            // Extend start bounds horizontally
            startScale = (float) startBounds.height() / finalBounds.height();
            float startWidth = startScale * finalBounds.width();
            float deltaWidth = (startWidth - startBounds.width()) / 2;
            startBounds.left -= deltaWidth;
            startBounds.right += deltaWidth;
        } else {
            // Extend start bounds vertically
            startScale = (float) startBounds.width() / finalBounds.width();
            float startHeight = startScale * finalBounds.height();
            float deltaHeight = (startHeight - startBounds.height()) / 2;
            startBounds.top -= deltaHeight;
            startBounds.bottom += deltaHeight;
        }

        originalView.setAlpha(0f);
        mExpandedImageViewOverlay.setVisibility(View.VISIBLE);
        mExpandedImageView.setVisibility(View.VISIBLE);
        mExpandedImageView.setPivotX(0f);
        mExpandedImageView.setPivotY(0f);

        AnimatorSet set = new AnimatorSet();
        set
                .play(ObjectAnimator.ofFloat(mExpandedImageView, View.X,
                        startBounds.left, finalBounds.left))
                .with(ObjectAnimator.ofFloat(mExpandedImageView, View.Y,
                        startBounds.top, finalBounds.top))
                .with(ObjectAnimator.ofFloat(mExpandedImageView, View.SCALE_X,
                        startScale, 1f)).with(ObjectAnimator.ofFloat(mExpandedImageView,
                View.SCALE_Y, startScale, 1f));
        set.setDuration(mAnimationDuration);
        set.setInterpolator(new DecelerateInterpolator());
        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                mAnimator = null;
                if (mActionBar != null)
                    mActionBar.hide();
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                mAnimator = null;
            }
        });
        set.start();
        mAnimator = set;

        final float startScaleFinal = startScale;
        mExpandedImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mAnimator != null) {
                    mAnimator.cancel();
                }

                // Animate the four positioning/sizing properties in parallel,
                // back to their original values.
                AnimatorSet set = new AnimatorSet();
                set.play(ObjectAnimator
                        .ofFloat(mExpandedImageView, View.X, startBounds.left))
                        .with(ObjectAnimator
                                .ofFloat(mExpandedImageView,
                                        View.Y,startBounds.top))
                        .with(ObjectAnimator
                                .ofFloat(mExpandedImageView,
                                        View.SCALE_X, startScaleFinal))
                        .with(ObjectAnimator
                                .ofFloat(mExpandedImageView,
                                        View.SCALE_Y, startScaleFinal));
                set.setDuration(mAnimationDuration);
                set.setInterpolator(new DecelerateInterpolator());
                set.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        originalView.setAlpha(1f);
                        mExpandedImageView.setVisibility(View.GONE);
                        mExpandedImageViewOverlay.setVisibility(View.GONE);
                        if (mActionBar != null)
                            mActionBar.show();
                        mAnimator = null;
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {
                        originalView.setAlpha(1f);
                        mExpandedImageView.setVisibility(View.GONE);
                        mExpandedImageViewOverlay.setVisibility(View.GONE);
                        if (mActionBar != null)
                            mActionBar.show();
                        mAnimator = null;
                    }
                });
                set.start();
                mAnimator = set;
            }
        });

    }
}
