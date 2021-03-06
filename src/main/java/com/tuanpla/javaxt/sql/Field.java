package com.tuanpla.javaxt.sql;

//******************************************************************************
//**  Field Class
//******************************************************************************
/**
 *   Used to represent a field in a Recordset.
 *
 ******************************************************************************/

public class Field {

    private String Name = null;
    protected String Type = null;
    protected Value Value = null;
    private String Table = null;
    private String Schema = null;
    protected String Class = null;
    protected boolean RequiresUpdate = false;


  //**************************************************************************
  //** Constructor
  //**************************************************************************
  /** Creates a new instance of this class. */

    protected Field(int i, java.sql.ResultSetMetaData rsmd){
         try{ Name = getValue(rsmd.getColumnName(i)); } catch(Exception e){}
         try{ Table = getValue(rsmd.getTableName(i)); } catch(Exception e){}
         try{ Schema = getValue(rsmd.getSchemaName(i)); } catch(Exception e){}
         try{ Type = getValue(rsmd.getColumnTypeName(i)); } catch(Exception e){}
         try{ Class = getValue(rsmd.getColumnClassName(i)); } catch(Exception e){}
    }


  //**************************************************************************
  //** getName
  //**************************************************************************
  /** Returns the name of the column associated with this field. Returns null
   *  if the column name is unknown.
   */
    public String getName(){
        return Name;
    }


  //**************************************************************************
  //** getValue
  //**************************************************************************
  /** Returns the value for this field. */
    
    public Value getValue(){
        if (Value==null) Value = new Value(null);
        return Value;
    }


  //**************************************************************************
  //** getTable
  //**************************************************************************
  /** Returns the name of the table in which this field is found. Returns null
   *  if the table name is unknown.
   */

    public String getTable(){
        return Table;
    }

    protected void setTableName(String tableName){
        Table = getValue(tableName);
    }


  //**************************************************************************
  //** getSchema
  //**************************************************************************
  /** Returns the name of the schema to which this field belongs. Schemas are
   *  used to group objects in the database and are often used for access
   *  control. Returns null if the schema name is unknown.
   */
    protected String getSchema(){
        return Schema;
    }

    protected void setSchemaName(String schema){
        Schema = getValue(schema);
    }


  //**************************************************************************
  //** isDirty
  //**************************************************************************
  /** Returns true if the value for this field has changed. */

    public boolean isDirty(){
        return RequiresUpdate;
    }


  //**************************************************************************
  //** clear
  //**************************************************************************
  /** Used to delete all the attributes of this field. */

    protected void clear(){
        Name = null;
        Type = null;
        Value = new Value(null);
        Table = null;
        Schema = null;
        Class = null;
    }



    private String getValue(String str){
        if (str!=null){
            if (str.trim().length()==0) return null;
        }
        return str;
    }
}