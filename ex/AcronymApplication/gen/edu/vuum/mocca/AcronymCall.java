/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /Users/chen/Dropbox/Java/android/POSA-14-master/ex/AcronymApplication/src/edu/vuum/mocca/AcronymCall.aidl
 */
package edu.vuum.mocca;
/**
 * Interface defining the method that the AcronymServiceSync will
 * implement to provide synchronous access to the Acronym Web service.
 */
public interface AcronymCall extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements edu.vuum.mocca.AcronymCall
{
private static final java.lang.String DESCRIPTOR = "edu.vuum.mocca.AcronymCall";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an edu.vuum.mocca.AcronymCall interface,
 * generating a proxy if needed.
 */
public static edu.vuum.mocca.AcronymCall asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof edu.vuum.mocca.AcronymCall))) {
return ((edu.vuum.mocca.AcronymCall)iin);
}
return new edu.vuum.mocca.AcronymCall.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_expandAcronym:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.util.List<edu.vuum.mocca.AcronymData> _result = this.expandAcronym(_arg0);
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements edu.vuum.mocca.AcronymCall
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/**
    * A two-way (blocking) call to the AcronymServiceSync that
    * retrieves information about an acronym from the Acronym Web
    * service and returns a list of AcronymData containing the results
    * from the Web service back to the AcronymActivity.
    */
@Override public java.util.List<edu.vuum.mocca.AcronymData> expandAcronym(java.lang.String acronym) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<edu.vuum.mocca.AcronymData> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(acronym);
mRemote.transact(Stub.TRANSACTION_expandAcronym, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(edu.vuum.mocca.AcronymData.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_expandAcronym = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
/**
    * A two-way (blocking) call to the AcronymServiceSync that
    * retrieves information about an acronym from the Acronym Web
    * service and returns a list of AcronymData containing the results
    * from the Web service back to the AcronymActivity.
    */
public java.util.List<edu.vuum.mocca.AcronymData> expandAcronym(java.lang.String acronym) throws android.os.RemoteException;
}
