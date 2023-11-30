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
public class CountryAvro extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -7492913842510952444L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Country\",\"namespace\":\"kafka.producer.location.schema\",\"fields\":[{\"name\":\"alternateCodes\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"AlternateCode\",\"fields\":[{\"name\":\"code\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"codeType\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]}}},{\"name\":\"name\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<CountryAvro> ENCODER =
      new BinaryMessageEncoder<CountryAvro>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<CountryAvro> DECODER =
      new BinaryMessageDecoder<CountryAvro>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<CountryAvro> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<CountryAvro> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<CountryAvro> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<CountryAvro>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this Country to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a Country from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a Country instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static CountryAvro fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.util.List<AlternateCodeAvro> alternateCodes;
  private java.lang.String name;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public CountryAvro() {}

  /**
   * All-args constructor.
   * @param alternateCodes The new value for alternateCodes
   * @param name The new value for name
   */
  public CountryAvro(java.util.List<AlternateCodeAvro> alternateCodes, java.lang.String name) {
    this.alternateCodes = alternateCodes;
    this.name = name;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return alternateCodes;
    case 1: return name;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: alternateCodes = (java.util.List<AlternateCodeAvro>)value$; break;
    case 1: name = value$ != null ? value$.toString() : null; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'alternateCodes' field.
   * @return The value of the 'alternateCodes' field.
   */
  public java.util.List<AlternateCodeAvro> getAlternateCodes() {
    return alternateCodes;
  }


  /**
   * Sets the value of the 'alternateCodes' field.
   * @param value the value to set.
   */
  public void setAlternateCodes(java.util.List<AlternateCodeAvro> value) {
    this.alternateCodes = value;
  }

  /**
   * Gets the value of the 'name' field.
   * @return The value of the 'name' field.
   */
  public java.lang.String getName() {
    return name;
  }


  /**
   * Sets the value of the 'name' field.
   * @param value the value to set.
   */
  public void setName(java.lang.String value) {
    this.name = value;
  }

  /**
   * Creates a new Country RecordBuilder.
   * @return A new Country RecordBuilder
   */
  public static CountryAvro.Builder newBuilder() {
    return new CountryAvro.Builder();
  }

  /**
   * Creates a new Country RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Country RecordBuilder
   */
  public static CountryAvro.Builder newBuilder(CountryAvro.Builder other) {
    if (other == null) {
      return new CountryAvro.Builder();
    } else {
      return new CountryAvro.Builder(other);
    }
  }

  /**
   * Creates a new Country RecordBuilder by copying an existing Country instance.
   * @param other The existing instance to copy.
   * @return A new Country RecordBuilder
   */
  public static CountryAvro.Builder newBuilder(CountryAvro other) {
    if (other == null) {
      return new CountryAvro.Builder();
    } else {
      return new CountryAvro.Builder(other);
    }
  }

  /**
   * RecordBuilder for Country instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<CountryAvro>
    implements org.apache.avro.data.RecordBuilder<CountryAvro> {

    private java.util.List<AlternateCodeAvro> alternateCodes;
    private java.lang.String name;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(CountryAvro.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.alternateCodes)) {
        this.alternateCodes = data().deepCopy(fields()[0].schema(), other.alternateCodes);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.name)) {
        this.name = data().deepCopy(fields()[1].schema(), other.name);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
    }

    /**
     * Creates a Builder by copying an existing Country instance
     * @param other The existing instance to copy.
     */
    private Builder(CountryAvro other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.alternateCodes)) {
        this.alternateCodes = data().deepCopy(fields()[0].schema(), other.alternateCodes);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.name)) {
        this.name = data().deepCopy(fields()[1].schema(), other.name);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'alternateCodes' field.
      * @return The value.
      */
    public java.util.List<AlternateCodeAvro> getAlternateCodes() {
      return alternateCodes;
    }


    /**
      * Sets the value of the 'alternateCodes' field.
      * @param value The value of 'alternateCodes'.
      * @return This builder.
      */
    public CountryAvro.Builder setAlternateCodes(java.util.List<AlternateCodeAvro> value) {
      validate(fields()[0], value);
      this.alternateCodes = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'alternateCodes' field has been set.
      * @return True if the 'alternateCodes' field has been set, false otherwise.
      */
    public boolean hasAlternateCodes() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'alternateCodes' field.
      * @return This builder.
      */
    public CountryAvro.Builder clearAlternateCodes() {
      alternateCodes = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'name' field.
      * @return The value.
      */
    public java.lang.String getName() {
      return name;
    }


    /**
      * Sets the value of the 'name' field.
      * @param value The value of 'name'.
      * @return This builder.
      */
    public CountryAvro.Builder setName(java.lang.String value) {
      validate(fields()[1], value);
      this.name = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'name' field has been set.
      * @return True if the 'name' field has been set, false otherwise.
      */
    public boolean hasName() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'name' field.
      * @return This builder.
      */
    public CountryAvro.Builder clearName() {
      name = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public CountryAvro build() {
      try {
        CountryAvro record = new CountryAvro();
        record.alternateCodes = fieldSetFlags()[0] ? this.alternateCodes : (java.util.List<AlternateCodeAvro>) defaultValue(fields()[0]);
        record.name = fieldSetFlags()[1] ? this.name : (java.lang.String) defaultValue(fields()[1]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<CountryAvro>
    WRITER$ = (org.apache.avro.io.DatumWriter<CountryAvro>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<CountryAvro>
    READER$ = (org.apache.avro.io.DatumReader<CountryAvro>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    long size0 = this.alternateCodes.size();
    out.writeArrayStart();
    out.setItemCount(size0);
    long actualSize0 = 0;
    for (AlternateCodeAvro e0: this.alternateCodes) {
      actualSize0++;
      out.startItem();
      e0.customEncode(out);
    }
    out.writeArrayEnd();
    if (actualSize0 != size0)
      throw new java.util.ConcurrentModificationException("Array-size written was " + size0 + ", but element count was " + actualSize0 + ".");

    out.writeString(this.name);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      long size0 = in.readArrayStart();
      java.util.List<AlternateCodeAvro> a0 = this.alternateCodes;
      if (a0 == null) {
        a0 = new SpecificData.Array<AlternateCodeAvro>((int)size0, SCHEMA$.getField("alternateCodes").schema());
        this.alternateCodes = a0;
      } else a0.clear();
      SpecificData.Array<AlternateCodeAvro> ga0 = (a0 instanceof SpecificData.Array ? (SpecificData.Array<AlternateCodeAvro>)a0 : null);
      for ( ; 0 < size0; size0 = in.arrayNext()) {
        for ( ; size0 != 0; size0--) {
          AlternateCodeAvro e0 = (ga0 != null ? ga0.peek() : null);
          if (e0 == null) {
            e0 = new AlternateCodeAvro();
          }
          e0.customDecode(in);
          a0.add(e0);
        }
      }

      this.name = in.readString();

    } else {
      for (int i = 0; i < 2; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          long size0 = in.readArrayStart();
          java.util.List<AlternateCodeAvro> a0 = this.alternateCodes;
          if (a0 == null) {
            a0 = new SpecificData.Array<AlternateCodeAvro>((int)size0, SCHEMA$.getField("alternateCodes").schema());
            this.alternateCodes = a0;
          } else a0.clear();
          SpecificData.Array<AlternateCodeAvro> ga0 = (a0 instanceof SpecificData.Array ? (SpecificData.Array<AlternateCodeAvro>)a0 : null);
          for ( ; 0 < size0; size0 = in.arrayNext()) {
            for ( ; size0 != 0; size0--) {
              AlternateCodeAvro e0 = (ga0 != null ? ga0.peek() : null);
              if (e0 == null) {
                e0 = new AlternateCodeAvro();
              }
              e0.customDecode(in);
              a0.add(e0);
            }
          }
          break;

        case 1:
          this.name = in.readString();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










