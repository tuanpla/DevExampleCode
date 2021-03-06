package com.tuanpla.utils;

//******************************************************************************
//**  Value Class
//******************************************************************************
/**
 *   A general purpose wrapper for Objects. The value can be converted into a
 *   number of Java primatives including strings, integers, doubles, booleans,
 *   etc.
 *
 ******************************************************************************/

public class Value {

    private Object value = null;

  //**************************************************************************
  //** Constructor
  //**************************************************************************
  /** Creates a new instance of this class. */

    public Value(Object value){
        this.value = value;
    }

    public Object toObject(){
        return value;
    }

    
  //**************************************************************************
  //** toInteger
  //**************************************************************************
  /** Returns the value as an integer. Returns a null if there was a problem
   *  converting the value to an integer or if the value is null.
   */
    public Integer toInteger(){
        if (value==null) return null;
        try{
            return Integer.valueOf(value+"");
        }
        catch(Exception e){
            return null;
        }
    }


  //**************************************************************************
  //** toShort
  //**************************************************************************
  /** Returns the value as a short. Returns a null if there was a problem
   *  converting the value to a short or if the value is null.
   */
    public Short toShort(){
        if (value==null) return null;
        try{
            return Short.valueOf(value+"");
        }
        catch(Exception e){
            return null;
        }
    }


  //**************************************************************************
  //** toDouble
  //**************************************************************************
  /** Returns the value as a double. Returns a null if there was a problem
   *  converting the value to a double or if the value is null.
   */
    public Double toDouble(){
        if (value==null) return null;
        try{
            return Double.valueOf(value+"");
        }
        catch(Exception e){
            return null;
        }
    }


  //**************************************************************************
  //** toLong
  //**************************************************************************
  /** Returns the value as a long. Returns a null if there was a problem
   *  converting the value to a long or if the value is null.
   */
    public Long toLong(){
        if (value==null) return null;
        try{
            return Long.valueOf(value+"");
        }
        catch(Exception e){
            return null;
        }
    }


  //**************************************************************************
  //** toBigDecimal
  //**************************************************************************
  /** Returns the value as a BigDecimal. Returns a null if there was a problem
   *  converting the value to a BigDecimal or if the value is null.
   */
    public java.math.BigDecimal toBigDecimal(){
        if (value==null) return null;
        try{
            return java.math.BigDecimal.valueOf(toDouble());
        }
        catch(Exception e){
            return null;
        }
    }


  //**************************************************************************
  //** toFloat
  //**************************************************************************
  /** Returns the value as a float. Returns a null if there was a problem
   *  converting the value to a float or if the value is null.
   */
    public Float toFloat(){
        if (value==null) return null;
        try{
            return Float.valueOf(value+"");
        }
        catch(Exception e){
            return null;
        }
    }


  //**************************************************************************
  //** toDate
  //**************************************************************************
  /** Returns the value as a Date. Returns a null if there was a problem
   *  converting the value to a Date or if the value is null.
   */
    public Date toDate(){
        if (value==null) return null;
        try{
            return new Date(value.toString());
        }
        catch(Exception e){
            return null;
        }
    }

    
  //**************************************************************************
  //** toByteArray
  //**************************************************************************
  /** Returns the value as a byte array.
   */
    public byte[] toByteArray(){
        if (value==null) return null;
        if (value instanceof byte[]) return (byte[]) value;

        java.io.ByteArrayOutputStream bos = new java.io.ByteArrayOutputStream();
        try {
            java.io.ObjectOutputStream out = new java.io.ObjectOutputStream(bos);
            out.writeObject(value);
            out.flush();
            out.close();
            bos.close();
            return bos.toByteArray();
        }
        catch (java.io.IOException ex) {
            return null;
        }
    }


  //**************************************************************************
  //** toBoolean
  //**************************************************************************
  /**  Returns a boolean value for the field. */

    public Boolean toBoolean(){
        if (value!=null){
            String value = this.value.toString().toLowerCase().trim();

            if (value.equals("true")) return true;
            if (value.equals("false")) return false;

            if (value.equals("yes")) return true;
            if (value.equals("no")) return false;

            if (value.equals("y")) return true;
            if (value.equals("n")) return false;

            if (value.equals("t")) return true;
            if (value.equals("f")) return false;

            if (value.equals("1")) return true;
            if (value.equals("0")) return false;

        }
        return null;
    }


  //**************************************************************************
  //** isNumeric
  //**************************************************************************
  /**  Used to determine if the value is numeric. */

    public boolean isNumeric(){
        return (toDouble()!=null);
    }


  //**************************************************************************
  //** isArray
  //**************************************************************************
  /**  Used to determine whether the value is an array. */

    public boolean isArray(){
        return value!=null && value.getClass().isArray();
    }


  //**************************************************************************
  //** isNull
  //**************************************************************************
  /**  Used to determine whether the value is null. */

    public boolean isNull(){
        return value==null;
    }


  //**************************************************************************
  //** toString
  //**************************************************************************
  /** Returns a string representation of the object by calling the object's
   *  native toString() method. Returns a null if the object itself is null.
   */
    public String toString(){
        if (value==null) return null;
        else return value.toString();
    }


  //**************************************************************************
  //** equals
  //**************************************************************************
  /**  Used to compare values. Accepts any object. */

    public boolean equals(Object obj){
        if (obj instanceof Value) obj = ((Value) obj).toObject();
        if (obj==null) {
            if (value==null) return true;
            else return false;
        }
        else{
            if (value==null) return false;
        }
        return obj.equals(value);
    }
}