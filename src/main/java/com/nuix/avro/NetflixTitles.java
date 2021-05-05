/**
 * Autogenerated by Avro
 * <p>
 * DO NOT EDIT DIRECTLY
 */
package com.nuix.avro;

import com.nuix.conversions.LocalDateConversion;
import com.univocity.parsers.annotations.Convert;
import com.univocity.parsers.annotations.Parsed;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.SchemaStore;
import org.apache.avro.specific.SpecificData;

@org.apache.avro.specific.AvroGenerated
public class NetflixTitles extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -714758209544627283L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"NetflixTitles\",\"namespace\":\"com.nuix.avro\",\"fields\":[{\"name\":\"show_id\",\"type\":\"string\"},{\"name\":\"type\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"title\",\"type\":\"string\"},{\"name\":\"director\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"cast\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"country\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"date_added\",\"type\":[\"null\",{\"type\":\"int\",\"logicalType\":\"date\"}]},{\"name\":\"release_year\",\"type\":[\"null\",\"int\"],\"default\":null},{\"name\":\"rating\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"duration\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"listed_in\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"description\",\"type\":[\"null\",\"string\"],\"default\":null}]}");

  public static org.apache.avro.Schema getClassSchema() {
    return SCHEMA$;
  }

  private static SpecificData MODEL$ = new SpecificData();

  static {
    MODEL$.addLogicalTypeConversion(new org.apache.avro.data.TimeConversions.DateConversion());
  }

  private static final BinaryMessageEncoder<NetflixTitles> ENCODER =
          new BinaryMessageEncoder<NetflixTitles>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<NetflixTitles> DECODER =
          new BinaryMessageDecoder<NetflixTitles>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<NetflixTitles> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<NetflixTitles> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<NetflixTitles> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<NetflixTitles>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this NetflixTitles to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a NetflixTitles from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a NetflixTitles instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static NetflixTitles fromByteBuffer(
          java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Parsed
  private java.lang.CharSequence show_id;
  @Parsed
  private java.lang.CharSequence type;
  @Parsed
  private java.lang.CharSequence title;
  @Parsed
  private java.lang.CharSequence director;
  @Parsed
  private java.lang.CharSequence cast;
  @Parsed
  private java.lang.CharSequence country;
  @Convert(conversionClass = LocalDateConversion.class, args = {"MMMM d, yyyy"})
  @Parsed
  private java.time.LocalDate date_added;
  @Parsed
  private java.lang.Integer release_year;
  @Parsed
  private java.lang.CharSequence rating;
  @Parsed
  private java.lang.CharSequence duration;
  @Parsed
  private java.lang.CharSequence listed_in;
  @Parsed
  private java.lang.CharSequence description;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public NetflixTitles() {
  }

  /**
   * All-args constructor.
   * @param show_id The new value for show_id
   * @param type The new value for type
   * @param title The new value for title
   * @param director The new value for director
   * @param cast The new value for cast
   * @param country The new value for country
   * @param date_added The new value for date_added
   * @param release_year The new value for release_year
   * @param rating The new value for rating
   * @param duration The new value for duration
   * @param listed_in The new value for listed_in
   * @param description The new value for description
   */
  public NetflixTitles(java.lang.CharSequence show_id, java.lang.CharSequence type, java.lang.CharSequence title, java.lang.CharSequence director, java.lang.CharSequence cast, java.lang.CharSequence country, java.time.LocalDate date_added, java.lang.Integer release_year, java.lang.CharSequence rating, java.lang.CharSequence duration, java.lang.CharSequence listed_in, java.lang.CharSequence description) {
    this.show_id = show_id;
    this.type = type;
    this.title = title;
    this.director = director;
    this.cast = cast;
    this.country = country;
    this.date_added = date_added;
    this.release_year = release_year;
    this.rating = rating;
    this.duration = duration;
    this.listed_in = listed_in;
    this.description = description;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() {
    return MODEL$;
  }

  public org.apache.avro.Schema getSchema() {
    return SCHEMA$;
  }

  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
      case 0:
        return show_id;
      case 1:
        return type;
      case 2:
        return title;
      case 3:
        return director;
      case 4:
        return cast;
      case 5:
        return country;
      case 6:
        return date_added;
      case 7:
        return release_year;
      case 8:
        return rating;
      case 9:
        return duration;
      case 10:
        return listed_in;
      case 11:
        return description;
      default:
        throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value = "unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
      case 0:
        show_id = (java.lang.CharSequence) value$;
        break;
      case 1:
        type = (java.lang.CharSequence) value$;
        break;
      case 2:
        title = (java.lang.CharSequence) value$;
        break;
      case 3:
        director = (java.lang.CharSequence) value$;
        break;
      case 4:
        cast = (java.lang.CharSequence) value$;
        break;
      case 5:
        country = (java.lang.CharSequence) value$;
        break;
      case 6:
        date_added = (java.time.LocalDate) value$;
        break;
      case 7:
        release_year = (java.lang.Integer) value$;
        break;
      case 8:
        rating = (java.lang.CharSequence) value$;
        break;
      case 9:
        duration = (java.lang.CharSequence) value$;
        break;
      case 10:
        listed_in = (java.lang.CharSequence) value$;
        break;
      case 11:
        description = (java.lang.CharSequence) value$;
        break;
      default:
        throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'show_id' field.
   * @return The value of the 'show_id' field.
   */
  public java.lang.CharSequence getShowId() {
    return show_id;
  }


  /**
   * Sets the value of the 'show_id' field.
   * @param value the value to set.
   */
  public void setShowId(java.lang.CharSequence value) {
    this.show_id = value;
  }

  /**
   * Gets the value of the 'type' field.
   * @return The value of the 'type' field.
   */
  public java.lang.CharSequence getType() {
    return type;
  }


  /**
   * Sets the value of the 'type' field.
   * @param value the value to set.
   */
  public void setType(java.lang.CharSequence value) {
    this.type = value;
  }

  /**
   * Gets the value of the 'title' field.
   * @return The value of the 'title' field.
   */
  public java.lang.CharSequence getTitle() {
    return title;
  }


  /**
   * Sets the value of the 'title' field.
   * @param value the value to set.
   */
  public void setTitle(java.lang.CharSequence value) {
    this.title = value;
  }

  /**
   * Gets the value of the 'director' field.
   * @return The value of the 'director' field.
   */
  public java.lang.CharSequence getDirector() {
    return director;
  }


  /**
   * Sets the value of the 'director' field.
   * @param value the value to set.
   */
  public void setDirector(java.lang.CharSequence value) {
    this.director = value;
  }

  /**
   * Gets the value of the 'cast' field.
   * @return The value of the 'cast' field.
   */
  public java.lang.CharSequence getCast() {
    return cast;
  }


  /**
   * Sets the value of the 'cast' field.
   * @param value the value to set.
   */
  public void setCast(java.lang.CharSequence value) {
    this.cast = value;
  }

  /**
   * Gets the value of the 'country' field.
   * @return The value of the 'country' field.
   */
  public java.lang.CharSequence getCountry() {
    return country;
  }


  /**
   * Sets the value of the 'country' field.
   * @param value the value to set.
   */
  public void setCountry(java.lang.CharSequence value) {
    this.country = value;
  }

  /**
   * Gets the value of the 'date_added' field.
   * @return The value of the 'date_added' field.
   */
  public java.time.LocalDate getDateAdded() {
    return date_added;
  }


  /**
   * Sets the value of the 'date_added' field.
   * @param value the value to set.
   */
  public void setDateAdded(java.time.LocalDate value) {
    this.date_added = value;
  }

  /**
   * Gets the value of the 'release_year' field.
   * @return The value of the 'release_year' field.
   */
  public java.lang.Integer getReleaseYear() {
    return release_year;
  }


  /**
   * Sets the value of the 'release_year' field.
   * @param value the value to set.
   */
  public void setReleaseYear(java.lang.Integer value) {
    this.release_year = value;
  }

  /**
   * Gets the value of the 'rating' field.
   * @return The value of the 'rating' field.
   */
  public java.lang.CharSequence getRating() {
    return rating;
  }


  /**
   * Sets the value of the 'rating' field.
   * @param value the value to set.
   */
  public void setRating(java.lang.CharSequence value) {
    this.rating = value;
  }

  /**
   * Gets the value of the 'duration' field.
   * @return The value of the 'duration' field.
   */
  public java.lang.CharSequence getDuration() {
    return duration;
  }


  /**
   * Sets the value of the 'duration' field.
   * @param value the value to set.
   */
  public void setDuration(java.lang.CharSequence value) {
    this.duration = value;
  }

  /**
   * Gets the value of the 'listed_in' field.
   * @return The value of the 'listed_in' field.
   */
  public java.lang.CharSequence getListedIn() {
    return listed_in;
  }


  /**
   * Sets the value of the 'listed_in' field.
   * @param value the value to set.
   */
  public void setListedIn(java.lang.CharSequence value) {
    this.listed_in = value;
  }

  /**
   * Gets the value of the 'description' field.
   * @return The value of the 'description' field.
   */
  public java.lang.CharSequence getDescription() {
    return description;
  }


  /**
   * Sets the value of the 'description' field.
   * @param value the value to set.
   */
  public void setDescription(java.lang.CharSequence value) {
    this.description = value;
  }

  /**
   * Creates a new NetflixTitles RecordBuilder.
   * @return A new NetflixTitles RecordBuilder
   */
  public static com.nuix.avro.NetflixTitles.Builder newBuilder() {
    return new com.nuix.avro.NetflixTitles.Builder();
  }

  /**
   * Creates a new NetflixTitles RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new NetflixTitles RecordBuilder
   */
  public static com.nuix.avro.NetflixTitles.Builder newBuilder(com.nuix.avro.NetflixTitles.Builder other) {
    if (other == null) {
      return new com.nuix.avro.NetflixTitles.Builder();
    } else {
      return new com.nuix.avro.NetflixTitles.Builder(other);
    }
  }

  /**
   * Creates a new NetflixTitles RecordBuilder by copying an existing NetflixTitles instance.
   * @param other The existing instance to copy.
   * @return A new NetflixTitles RecordBuilder
   */
  public static com.nuix.avro.NetflixTitles.Builder newBuilder(com.nuix.avro.NetflixTitles other) {
    if (other == null) {
      return new com.nuix.avro.NetflixTitles.Builder();
    } else {
      return new com.nuix.avro.NetflixTitles.Builder(other);
    }
  }

  /**
   * RecordBuilder for NetflixTitles instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<NetflixTitles>
          implements org.apache.avro.data.RecordBuilder<NetflixTitles> {

    private java.lang.CharSequence show_id;
    private java.lang.CharSequence type;
    private java.lang.CharSequence title;
    private java.lang.CharSequence director;
    private java.lang.CharSequence cast;
    private java.lang.CharSequence country;
    private java.time.LocalDate date_added;
    private java.lang.Integer release_year;
    private java.lang.CharSequence rating;
    private java.lang.CharSequence duration;
    private java.lang.CharSequence listed_in;
    private java.lang.CharSequence description;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.nuix.avro.NetflixTitles.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.show_id)) {
        this.show_id = data().deepCopy(fields()[0].schema(), other.show_id);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.type)) {
        this.type = data().deepCopy(fields()[1].schema(), other.type);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.title)) {
        this.title = data().deepCopy(fields()[2].schema(), other.title);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.director)) {
        this.director = data().deepCopy(fields()[3].schema(), other.director);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.cast)) {
        this.cast = data().deepCopy(fields()[4].schema(), other.cast);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
      if (isValidValue(fields()[5], other.country)) {
        this.country = data().deepCopy(fields()[5].schema(), other.country);
        fieldSetFlags()[5] = other.fieldSetFlags()[5];
      }
      if (isValidValue(fields()[6], other.date_added)) {
        this.date_added = data().deepCopy(fields()[6].schema(), other.date_added);
        fieldSetFlags()[6] = other.fieldSetFlags()[6];
      }
      if (isValidValue(fields()[7], other.release_year)) {
        this.release_year = data().deepCopy(fields()[7].schema(), other.release_year);
        fieldSetFlags()[7] = other.fieldSetFlags()[7];
      }
      if (isValidValue(fields()[8], other.rating)) {
        this.rating = data().deepCopy(fields()[8].schema(), other.rating);
        fieldSetFlags()[8] = other.fieldSetFlags()[8];
      }
      if (isValidValue(fields()[9], other.duration)) {
        this.duration = data().deepCopy(fields()[9].schema(), other.duration);
        fieldSetFlags()[9] = other.fieldSetFlags()[9];
      }
      if (isValidValue(fields()[10], other.listed_in)) {
        this.listed_in = data().deepCopy(fields()[10].schema(), other.listed_in);
        fieldSetFlags()[10] = other.fieldSetFlags()[10];
      }
      if (isValidValue(fields()[11], other.description)) {
        this.description = data().deepCopy(fields()[11].schema(), other.description);
        fieldSetFlags()[11] = other.fieldSetFlags()[11];
      }
    }

    /**
     * Creates a Builder by copying an existing NetflixTitles instance
     * @param other The existing instance to copy.
     */
    private Builder(com.nuix.avro.NetflixTitles other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.show_id)) {
        this.show_id = data().deepCopy(fields()[0].schema(), other.show_id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.type)) {
        this.type = data().deepCopy(fields()[1].schema(), other.type);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.title)) {
        this.title = data().deepCopy(fields()[2].schema(), other.title);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.director)) {
        this.director = data().deepCopy(fields()[3].schema(), other.director);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.cast)) {
        this.cast = data().deepCopy(fields()[4].schema(), other.cast);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.country)) {
        this.country = data().deepCopy(fields()[5].schema(), other.country);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.date_added)) {
        this.date_added = data().deepCopy(fields()[6].schema(), other.date_added);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.release_year)) {
        this.release_year = data().deepCopy(fields()[7].schema(), other.release_year);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.rating)) {
        this.rating = data().deepCopy(fields()[8].schema(), other.rating);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.duration)) {
        this.duration = data().deepCopy(fields()[9].schema(), other.duration);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.listed_in)) {
        this.listed_in = data().deepCopy(fields()[10].schema(), other.listed_in);
        fieldSetFlags()[10] = true;
      }
      if (isValidValue(fields()[11], other.description)) {
        this.description = data().deepCopy(fields()[11].schema(), other.description);
        fieldSetFlags()[11] = true;
      }
    }

    /**
     * Gets the value of the 'show_id' field.
     * @return The value.
     */
    public java.lang.CharSequence getShowId() {
      return show_id;
    }


    /**
     * Sets the value of the 'show_id' field.
     * @param value The value of 'show_id'.
     * @return This builder.
     */
    public com.nuix.avro.NetflixTitles.Builder setShowId(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.show_id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
     * Checks whether the 'show_id' field has been set.
     * @return True if the 'show_id' field has been set, false otherwise.
     */
    public boolean hasShowId() {
      return fieldSetFlags()[0];
    }


    /**
     * Clears the value of the 'show_id' field.
     * @return This builder.
     */
    public com.nuix.avro.NetflixTitles.Builder clearShowId() {
      show_id = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
     * Gets the value of the 'type' field.
     * @return The value.
     */
    public java.lang.CharSequence getType() {
      return type;
    }


    /**
     * Sets the value of the 'type' field.
     * @param value The value of 'type'.
     * @return This builder.
     */
    public com.nuix.avro.NetflixTitles.Builder setType(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.type = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
     * Checks whether the 'type' field has been set.
     * @return True if the 'type' field has been set, false otherwise.
     */
    public boolean hasType() {
      return fieldSetFlags()[1];
    }


    /**
     * Clears the value of the 'type' field.
     * @return This builder.
     */
    public com.nuix.avro.NetflixTitles.Builder clearType() {
      type = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
     * Gets the value of the 'title' field.
     * @return The value.
     */
    public java.lang.CharSequence getTitle() {
      return title;
    }


    /**
     * Sets the value of the 'title' field.
     * @param value The value of 'title'.
     * @return This builder.
     */
    public com.nuix.avro.NetflixTitles.Builder setTitle(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.title = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
     * Checks whether the 'title' field has been set.
     * @return True if the 'title' field has been set, false otherwise.
     */
    public boolean hasTitle() {
      return fieldSetFlags()[2];
    }


    /**
     * Clears the value of the 'title' field.
     * @return This builder.
     */
    public com.nuix.avro.NetflixTitles.Builder clearTitle() {
      title = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
     * Gets the value of the 'director' field.
     * @return The value.
     */
    public java.lang.CharSequence getDirector() {
      return director;
    }


    /**
     * Sets the value of the 'director' field.
     * @param value The value of 'director'.
     * @return This builder.
     */
    public com.nuix.avro.NetflixTitles.Builder setDirector(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.director = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
     * Checks whether the 'director' field has been set.
     * @return True if the 'director' field has been set, false otherwise.
     */
    public boolean hasDirector() {
      return fieldSetFlags()[3];
    }


    /**
     * Clears the value of the 'director' field.
     * @return This builder.
     */
    public com.nuix.avro.NetflixTitles.Builder clearDirector() {
      director = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
     * Gets the value of the 'cast' field.
     * @return The value.
     */
    public java.lang.CharSequence getCast() {
      return cast;
    }


    /**
     * Sets the value of the 'cast' field.
     * @param value The value of 'cast'.
     * @return This builder.
     */
    public com.nuix.avro.NetflixTitles.Builder setCast(java.lang.CharSequence value) {
      validate(fields()[4], value);
      this.cast = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
     * Checks whether the 'cast' field has been set.
     * @return True if the 'cast' field has been set, false otherwise.
     */
    public boolean hasCast() {
      return fieldSetFlags()[4];
    }


    /**
     * Clears the value of the 'cast' field.
     * @return This builder.
     */
    public com.nuix.avro.NetflixTitles.Builder clearCast() {
      cast = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
     * Gets the value of the 'country' field.
     * @return The value.
     */
    public java.lang.CharSequence getCountry() {
      return country;
    }


    /**
     * Sets the value of the 'country' field.
     * @param value The value of 'country'.
     * @return This builder.
     */
    public com.nuix.avro.NetflixTitles.Builder setCountry(java.lang.CharSequence value) {
      validate(fields()[5], value);
      this.country = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
     * Checks whether the 'country' field has been set.
     * @return True if the 'country' field has been set, false otherwise.
     */
    public boolean hasCountry() {
      return fieldSetFlags()[5];
    }


    /**
     * Clears the value of the 'country' field.
     * @return This builder.
     */
    public com.nuix.avro.NetflixTitles.Builder clearCountry() {
      country = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
     * Gets the value of the 'date_added' field.
     * @return The value.
     */
    public java.time.LocalDate getDateAdded() {
      return date_added;
    }


    /**
     * Sets the value of the 'date_added' field.
     * @param value The value of 'date_added'.
     * @return This builder.
     */
    public com.nuix.avro.NetflixTitles.Builder setDateAdded(java.time.LocalDate value) {
      validate(fields()[6], value);
      this.date_added = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
     * Checks whether the 'date_added' field has been set.
     * @return True if the 'date_added' field has been set, false otherwise.
     */
    public boolean hasDateAdded() {
      return fieldSetFlags()[6];
    }


    /**
     * Clears the value of the 'date_added' field.
     * @return This builder.
     */
    public com.nuix.avro.NetflixTitles.Builder clearDateAdded() {
      date_added = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    /**
     * Gets the value of the 'release_year' field.
     * @return The value.
     */
    public java.lang.Integer getReleaseYear() {
      return release_year;
    }


    /**
     * Sets the value of the 'release_year' field.
     * @param value The value of 'release_year'.
     * @return This builder.
     */
    public com.nuix.avro.NetflixTitles.Builder setReleaseYear(java.lang.Integer value) {
      validate(fields()[7], value);
      this.release_year = value;
      fieldSetFlags()[7] = true;
      return this;
    }

    /**
     * Checks whether the 'release_year' field has been set.
     * @return True if the 'release_year' field has been set, false otherwise.
     */
    public boolean hasReleaseYear() {
      return fieldSetFlags()[7];
    }


    /**
     * Clears the value of the 'release_year' field.
     * @return This builder.
     */
    public com.nuix.avro.NetflixTitles.Builder clearReleaseYear() {
      release_year = null;
      fieldSetFlags()[7] = false;
      return this;
    }

    /**
     * Gets the value of the 'rating' field.
     * @return The value.
     */
    public java.lang.CharSequence getRating() {
      return rating;
    }


    /**
     * Sets the value of the 'rating' field.
     * @param value The value of 'rating'.
     * @return This builder.
     */
    public com.nuix.avro.NetflixTitles.Builder setRating(java.lang.CharSequence value) {
      validate(fields()[8], value);
      this.rating = value;
      fieldSetFlags()[8] = true;
      return this;
    }

    /**
     * Checks whether the 'rating' field has been set.
     * @return True if the 'rating' field has been set, false otherwise.
     */
    public boolean hasRating() {
      return fieldSetFlags()[8];
    }


    /**
     * Clears the value of the 'rating' field.
     * @return This builder.
     */
    public com.nuix.avro.NetflixTitles.Builder clearRating() {
      rating = null;
      fieldSetFlags()[8] = false;
      return this;
    }

    /**
     * Gets the value of the 'duration' field.
     * @return The value.
     */
    public java.lang.CharSequence getDuration() {
      return duration;
    }


    /**
     * Sets the value of the 'duration' field.
     * @param value The value of 'duration'.
     * @return This builder.
     */
    public com.nuix.avro.NetflixTitles.Builder setDuration(java.lang.CharSequence value) {
      validate(fields()[9], value);
      this.duration = value;
      fieldSetFlags()[9] = true;
      return this;
    }

    /**
     * Checks whether the 'duration' field has been set.
     * @return True if the 'duration' field has been set, false otherwise.
     */
    public boolean hasDuration() {
      return fieldSetFlags()[9];
    }


    /**
     * Clears the value of the 'duration' field.
     * @return This builder.
     */
    public com.nuix.avro.NetflixTitles.Builder clearDuration() {
      duration = null;
      fieldSetFlags()[9] = false;
      return this;
    }

    /**
     * Gets the value of the 'listed_in' field.
     * @return The value.
     */
    public java.lang.CharSequence getListedIn() {
      return listed_in;
    }


    /**
     * Sets the value of the 'listed_in' field.
     * @param value The value of 'listed_in'.
     * @return This builder.
     */
    public com.nuix.avro.NetflixTitles.Builder setListedIn(java.lang.CharSequence value) {
      validate(fields()[10], value);
      this.listed_in = value;
      fieldSetFlags()[10] = true;
      return this;
    }

    /**
     * Checks whether the 'listed_in' field has been set.
     * @return True if the 'listed_in' field has been set, false otherwise.
     */
    public boolean hasListedIn() {
      return fieldSetFlags()[10];
    }


    /**
     * Clears the value of the 'listed_in' field.
     * @return This builder.
     */
    public com.nuix.avro.NetflixTitles.Builder clearListedIn() {
      listed_in = null;
      fieldSetFlags()[10] = false;
      return this;
    }

    /**
     * Gets the value of the 'description' field.
     * @return The value.
     */
    public java.lang.CharSequence getDescription() {
      return description;
    }


    /**
     * Sets the value of the 'description' field.
     * @param value The value of 'description'.
     * @return This builder.
     */
    public com.nuix.avro.NetflixTitles.Builder setDescription(java.lang.CharSequence value) {
      validate(fields()[11], value);
      this.description = value;
      fieldSetFlags()[11] = true;
      return this;
    }

    /**
     * Checks whether the 'description' field has been set.
     * @return True if the 'description' field has been set, false otherwise.
     */
    public boolean hasDescription() {
      return fieldSetFlags()[11];
    }


    /**
     * Clears the value of the 'description' field.
     * @return This builder.
     */
    public com.nuix.avro.NetflixTitles.Builder clearDescription() {
      description = null;
      fieldSetFlags()[11] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public NetflixTitles build() {
      try {
        NetflixTitles record = new NetflixTitles();
        record.show_id = fieldSetFlags()[0] ? this.show_id : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.type = fieldSetFlags()[1] ? this.type : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.title = fieldSetFlags()[2] ? this.title : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.director = fieldSetFlags()[3] ? this.director : (java.lang.CharSequence) defaultValue(fields()[3]);
        record.cast = fieldSetFlags()[4] ? this.cast : (java.lang.CharSequence) defaultValue(fields()[4]);
        record.country = fieldSetFlags()[5] ? this.country : (java.lang.CharSequence) defaultValue(fields()[5]);
        record.date_added = fieldSetFlags()[6] ? this.date_added : (java.time.LocalDate) defaultValue(fields()[6]);
        record.release_year = fieldSetFlags()[7] ? this.release_year : (java.lang.Integer) defaultValue(fields()[7]);
        record.rating = fieldSetFlags()[8] ? this.rating : (java.lang.CharSequence) defaultValue(fields()[8]);
        record.duration = fieldSetFlags()[9] ? this.duration : (java.lang.CharSequence) defaultValue(fields()[9]);
        record.listed_in = fieldSetFlags()[10] ? this.listed_in : (java.lang.CharSequence) defaultValue(fields()[10]);
        record.description = fieldSetFlags()[11] ? this.description : (java.lang.CharSequence) defaultValue(fields()[11]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<NetflixTitles>
          WRITER$ = (org.apache.avro.io.DatumWriter<NetflixTitles>) MODEL$.createDatumWriter(SCHEMA$);

  @Override
  public void writeExternal(java.io.ObjectOutput out)
          throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<NetflixTitles>
          READER$ = (org.apache.avro.io.DatumReader<NetflixTitles>) MODEL$.createDatumReader(SCHEMA$);

  @Override
  public void readExternal(java.io.ObjectInput in)
          throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}










