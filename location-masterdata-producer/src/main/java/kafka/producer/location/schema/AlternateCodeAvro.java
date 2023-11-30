/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package kafka.producer.location.schema;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class AlternateCodeAvro extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 279762967885014421L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"AlternateCode\",\"namespace\":\"kafka.producer.location.schema\",\"fields\":[{\"name\":\"code\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"codeType\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<AlternateCodeAvro> ENCODER =
      new BinaryMessageEncoder<AlternateCodeAvro>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<AlternateCodeAvro> DECODER =
      new BinaryMessageDecoder<AlternateCodeAvro>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<AlternateCodeAvro> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<AlternateCodeAvro> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<AlternateCodeAvro> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<AlternateCodeAvro>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this AlternateCode to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a AlternateCode from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a AlternateCode instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static AlternateCodeAvro fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.lang.String code;
  private java.lang.String codeType;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public AlternateCodeAvro() {}

  /**
   * All-args constructor.
   * @param code The new value for code
   * @param codeType The new value for codeType
   */
  public AlternateCodeAvro(java.lang.String code, java.lang.String codeType) {
    this.code = code;
    this.codeType = codeType;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return code;
    case 1: return codeType;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: code = value$ != null ? value$.toString() : null; break;
    case 1: codeType = value$ != null ? value$.toString() : null; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'code' field.
   * @return The value of the 'code' field.
   */
  public java.lang.String getCode() {
    return code;
  }


  /**
   * Sets the value of the 'code' field.
   * @param value the value to set.
   */
  public void setCode(java.lang.String value) {
    this.code = value;
  }

  /**
   * Gets the value of the 'codeType' field.
   * @return The value of the 'codeType' field.
   */
  public java.lang.String getCodeType() {
    return codeType;
  }


  /**
   * Sets the value of the 'codeType' field.
   * @param value the value to set.
   */
  public void setCodeType(java.lang.String value) {
    this.codeType = value;
  }

  /**
   * Creates a new AlternateCode RecordBuilder.
   * @return A new AlternateCode RecordBuilder
   */
  public static AlternateCodeAvro.Builder newBuilder() {
    return new AlternateCodeAvro.Builder();
  }

  /**
   * Creates a new AlternateCode RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new AlternateCode RecordBuilder
   */
  public static AlternateCodeAvro.Builder newBuilder(AlternateCodeAvro.Builder other) {
    if (other == null) {
      return new AlternateCodeAvro.Builder();
    } else {
      return new AlternateCodeAvro.Builder(other);
    }
  }

  /**
   * Creates a new AlternateCode RecordBuilder by copying an existing AlternateCode instance.
   * @param other The existing instance to copy.
   * @return A new AlternateCode RecordBuilder
   */
  public static AlternateCodeAvro.Builder newBuilder(AlternateCodeAvro other) {
    if (other == null) {
      return new AlternateCodeAvro.Builder();
    } else {
      return new AlternateCodeAvro.Builder(other);
    }
  }

  /**
   * RecordBuilder for AlternateCode instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<AlternateCodeAvro>
    implements org.apache.avro.data.RecordBuilder<AlternateCodeAvro> {

    private java.lang.String code;
    private java.lang.String codeType;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(AlternateCodeAvro.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.code)) {
        this.code = data().deepCopy(fields()[0].schema(), other.code);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.codeType)) {
        this.codeType = data().deepCopy(fields()[1].schema(), other.codeType);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
    }

    /**
     * Creates a Builder by copying an existing AlternateCode instance
     * @param other The existing instance to copy.
     */
    private Builder(AlternateCodeAvro other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.code)) {
        this.code = data().deepCopy(fields()[0].schema(), other.code);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.codeType)) {
        this.codeType = data().deepCopy(fields()[1].schema(), other.codeType);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'code' field.
      * @return The value.
      */
    public java.lang.String getCode() {
      return code;
    }


    /**
      * Sets the value of the 'code' field.
      * @param value The value of 'code'.
      * @return This builder.
      */
    public AlternateCodeAvro.Builder setCode(java.lang.String value) {
      validate(fields()[0], value);
      this.code = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'code' field has been set.
      * @return True if the 'code' field has been set, false otherwise.
      */
    public boolean hasCode() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'code' field.
      * @return This builder.
      */
    public AlternateCodeAvro.Builder clearCode() {
      code = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'codeType' field.
      * @return The value.
      */
    public java.lang.String getCodeType() {
      return codeType;
    }


    /**
      * Sets the value of the 'codeType' field.
      * @param value The value of 'codeType'.
      * @return This builder.
      */
    public AlternateCodeAvro.Builder setCodeType(java.lang.String value) {
      validate(fields()[1], value);
      this.codeType = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'codeType' field has been set.
      * @return True if the 'codeType' field has been set, false otherwise.
      */
    public boolean hasCodeType() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'codeType' field.
      * @return This builder.
      */
    public AlternateCodeAvro.Builder clearCodeType() {
      codeType = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public AlternateCodeAvro build() {
      try {
        AlternateCodeAvro record = new AlternateCodeAvro();
        record.code = fieldSetFlags()[0] ? this.code : (java.lang.String) defaultValue(fields()[0]);
        record.codeType = fieldSetFlags()[1] ? this.codeType : (java.lang.String) defaultValue(fields()[1]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<AlternateCodeAvro>
    WRITER$ = (org.apache.avro.io.DatumWriter<AlternateCodeAvro>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<AlternateCodeAvro>
    READER$ = (org.apache.avro.io.DatumReader<AlternateCodeAvro>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.code);

    out.writeString(this.codeType);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.code = in.readString();

      this.codeType = in.readString();

    } else {
      for (int i = 0; i < 2; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.code = in.readString();
          break;

        case 1:
          this.codeType = in.readString();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










