/**
 * Autogenerated by Thrift Compiler (1.0.0-dev)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package sebastians.challenge.networking;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (1.0.0-dev)", date = "2015-07-12")
public class User implements org.apache.thrift.TBase<User, User._Fields>, java.io.Serializable, Cloneable, Comparable<User> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("User");

  private static final org.apache.thrift.protocol.TField ID_FIELD_DESC = new org.apache.thrift.protocol.TField("id", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField PW_FIELD_DESC = new org.apache.thrift.protocol.TField("pw", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField CHECKCODE_FIELD_DESC = new org.apache.thrift.protocol.TField("checkcode", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField ONLINE_FIELD_DESC = new org.apache.thrift.protocol.TField("online", org.apache.thrift.protocol.TType.BOOL, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new UserStandardSchemeFactory());
    schemes.put(TupleScheme.class, new UserTupleSchemeFactory());
  }

  public String id; // required
  public String pw; // optional
  public int checkcode; // optional
  public boolean online; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ID((short)1, "id"),
    PW((short)2, "pw"),
    CHECKCODE((short)3, "checkcode"),
    ONLINE((short)4, "online");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // ID
          return ID;
        case 2: // PW
          return PW;
        case 3: // CHECKCODE
          return CHECKCODE;
        case 4: // ONLINE
          return ONLINE;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __CHECKCODE_ISSET_ID = 0;
  private static final int __ONLINE_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.PW,_Fields.CHECKCODE,_Fields.ONLINE};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ID, new org.apache.thrift.meta_data.FieldMetaData("id", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PW, new org.apache.thrift.meta_data.FieldMetaData("pw", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.CHECKCODE, new org.apache.thrift.meta_data.FieldMetaData("checkcode", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.ONLINE, new org.apache.thrift.meta_data.FieldMetaData("online", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(User.class, metaDataMap);
  }

  public User() {
  }

  public User(
    String id)
  {
    this();
    this.id = id;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public User(User other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetId()) {
      this.id = other.id;
    }
    if (other.isSetPw()) {
      this.pw = other.pw;
    }
    this.checkcode = other.checkcode;
    this.online = other.online;
  }

  public User deepCopy() {
    return new User(this);
  }

  @Override
  public void clear() {
    this.id = null;
    this.pw = null;
    setCheckcodeIsSet(false);
    this.checkcode = 0;
    setOnlineIsSet(false);
    this.online = false;
  }

  public String getId() {
    return this.id;
  }

  public User setId(String id) {
    this.id = id;
    return this;
  }

  public void unsetId() {
    this.id = null;
  }

  /** Returns true if field id is set (has been assigned a value) and false otherwise */
  public boolean isSetId() {
    return this.id != null;
  }

  public void setIdIsSet(boolean value) {
    if (!value) {
      this.id = null;
    }
  }

  public String getPw() {
    return this.pw;
  }

  public User setPw(String pw) {
    this.pw = pw;
    return this;
  }

  public void unsetPw() {
    this.pw = null;
  }

  /** Returns true if field pw is set (has been assigned a value) and false otherwise */
  public boolean isSetPw() {
    return this.pw != null;
  }

  public void setPwIsSet(boolean value) {
    if (!value) {
      this.pw = null;
    }
  }

  public int getCheckcode() {
    return this.checkcode;
  }

  public User setCheckcode(int checkcode) {
    this.checkcode = checkcode;
    setCheckcodeIsSet(true);
    return this;
  }

  public void unsetCheckcode() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __CHECKCODE_ISSET_ID);
  }

  /** Returns true if field checkcode is set (has been assigned a value) and false otherwise */
  public boolean isSetCheckcode() {
    return EncodingUtils.testBit(__isset_bitfield, __CHECKCODE_ISSET_ID);
  }

  public void setCheckcodeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __CHECKCODE_ISSET_ID, value);
  }

  public boolean isOnline() {
    return this.online;
  }

  public User setOnline(boolean online) {
    this.online = online;
    setOnlineIsSet(true);
    return this;
  }

  public void unsetOnline() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ONLINE_ISSET_ID);
  }

  /** Returns true if field online is set (has been assigned a value) and false otherwise */
  public boolean isSetOnline() {
    return EncodingUtils.testBit(__isset_bitfield, __ONLINE_ISSET_ID);
  }

  public void setOnlineIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ONLINE_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case ID:
      if (value == null) {
        unsetId();
      } else {
        setId((String)value);
      }
      break;

    case PW:
      if (value == null) {
        unsetPw();
      } else {
        setPw((String)value);
      }
      break;

    case CHECKCODE:
      if (value == null) {
        unsetCheckcode();
      } else {
        setCheckcode((Integer)value);
      }
      break;

    case ONLINE:
      if (value == null) {
        unsetOnline();
      } else {
        setOnline((Boolean)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case ID:
      return getId();

    case PW:
      return getPw();

    case CHECKCODE:
      return getCheckcode();

    case ONLINE:
      return isOnline();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case ID:
      return isSetId();
    case PW:
      return isSetPw();
    case CHECKCODE:
      return isSetCheckcode();
    case ONLINE:
      return isSetOnline();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof User)
      return this.equals((User)that);
    return false;
  }

  public boolean equals(User that) {
    if (that == null)
      return false;

    boolean this_present_id = true && this.isSetId();
    boolean that_present_id = true && that.isSetId();
    if (this_present_id || that_present_id) {
      if (!(this_present_id && that_present_id))
        return false;
      if (!this.id.equals(that.id))
        return false;
    }

    boolean this_present_pw = true && this.isSetPw();
    boolean that_present_pw = true && that.isSetPw();
    if (this_present_pw || that_present_pw) {
      if (!(this_present_pw && that_present_pw))
        return false;
      if (!this.pw.equals(that.pw))
        return false;
    }

    boolean this_present_checkcode = true && this.isSetCheckcode();
    boolean that_present_checkcode = true && that.isSetCheckcode();
    if (this_present_checkcode || that_present_checkcode) {
      if (!(this_present_checkcode && that_present_checkcode))
        return false;
      if (this.checkcode != that.checkcode)
        return false;
    }

    boolean this_present_online = true && this.isSetOnline();
    boolean that_present_online = true && that.isSetOnline();
    if (this_present_online || that_present_online) {
      if (!(this_present_online && that_present_online))
        return false;
      if (this.online != that.online)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_id = true && (isSetId());
    list.add(present_id);
    if (present_id)
      list.add(id);

    boolean present_pw = true && (isSetPw());
    list.add(present_pw);
    if (present_pw)
      list.add(pw);

    boolean present_checkcode = true && (isSetCheckcode());
    list.add(present_checkcode);
    if (present_checkcode)
      list.add(checkcode);

    boolean present_online = true && (isSetOnline());
    list.add(present_online);
    if (present_online)
      list.add(online);

    return list.hashCode();
  }

  @Override
  public int compareTo(User other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetId()).compareTo(other.isSetId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.id, other.id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPw()).compareTo(other.isSetPw());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPw()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.pw, other.pw);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetCheckcode()).compareTo(other.isSetCheckcode());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCheckcode()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.checkcode, other.checkcode);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetOnline()).compareTo(other.isSetOnline());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetOnline()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.online, other.online);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("User(");
    boolean first = true;

    sb.append("id:");
    if (this.id == null) {
      sb.append("null");
    } else {
      sb.append(this.id);
    }
    first = false;
    if (isSetPw()) {
      if (!first) sb.append(", ");
      sb.append("pw:");
      if (this.pw == null) {
        sb.append("null");
      } else {
        sb.append(this.pw);
      }
      first = false;
    }
    if (isSetCheckcode()) {
      if (!first) sb.append(", ");
      sb.append("checkcode:");
      sb.append(this.checkcode);
      first = false;
    }
    if (isSetOnline()) {
      if (!first) sb.append(", ");
      sb.append("online:");
      sb.append(this.online);
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class UserStandardSchemeFactory implements SchemeFactory {
    public UserStandardScheme getScheme() {
      return new UserStandardScheme();
    }
  }

  private static class UserStandardScheme extends StandardScheme<User> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, User struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.id = iprot.readString();
              struct.setIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // PW
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.pw = iprot.readString();
              struct.setPwIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // CHECKCODE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.checkcode = iprot.readI32();
              struct.setCheckcodeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // ONLINE
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.online = iprot.readBool();
              struct.setOnlineIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, User struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.id != null) {
        oprot.writeFieldBegin(ID_FIELD_DESC);
        oprot.writeString(struct.id);
        oprot.writeFieldEnd();
      }
      if (struct.pw != null) {
        if (struct.isSetPw()) {
          oprot.writeFieldBegin(PW_FIELD_DESC);
          oprot.writeString(struct.pw);
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetCheckcode()) {
        oprot.writeFieldBegin(CHECKCODE_FIELD_DESC);
        oprot.writeI32(struct.checkcode);
        oprot.writeFieldEnd();
      }
      if (struct.isSetOnline()) {
        oprot.writeFieldBegin(ONLINE_FIELD_DESC);
        oprot.writeBool(struct.online);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class UserTupleSchemeFactory implements SchemeFactory {
    public UserTupleScheme getScheme() {
      return new UserTupleScheme();
    }
  }

  private static class UserTupleScheme extends TupleScheme<User> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, User struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetId()) {
        optionals.set(0);
      }
      if (struct.isSetPw()) {
        optionals.set(1);
      }
      if (struct.isSetCheckcode()) {
        optionals.set(2);
      }
      if (struct.isSetOnline()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetId()) {
        oprot.writeString(struct.id);
      }
      if (struct.isSetPw()) {
        oprot.writeString(struct.pw);
      }
      if (struct.isSetCheckcode()) {
        oprot.writeI32(struct.checkcode);
      }
      if (struct.isSetOnline()) {
        oprot.writeBool(struct.online);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, User struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.id = iprot.readString();
        struct.setIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.pw = iprot.readString();
        struct.setPwIsSet(true);
      }
      if (incoming.get(2)) {
        struct.checkcode = iprot.readI32();
        struct.setCheckcodeIsSet(true);
      }
      if (incoming.get(3)) {
        struct.online = iprot.readBool();
        struct.setOnlineIsSet(true);
      }
    }
  }

}
