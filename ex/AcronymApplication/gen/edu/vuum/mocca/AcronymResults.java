/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /Users/chen/Dropbox/Java/android/POSA-14-master/ex/AcronymApplication/src/edu/vuum/mocca/AcronymResults.aidl
 */
package edu.vuum.mocca;
/**
 * Interface defining the method that receives callbacks from the
 * AcronymServiceAsync.
 */
public interface AcronymResults extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements edu.vuum.mocca.AcronymResults
{
private static final java.lang.String DESCRIPTOR = "edu.vuum.mocca.AcronymResults";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an edu.vuum.mocca.AcronymResults interface,
 * generating a proxy if needed.
 */
public static edu.vuum.mocca.AcronymResults asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof edu.vuum.mocca.AcronymResults))) {
return ((edu.vuum.mocca.AcronymResults)iin);
}
return new edu.vuum.mocca.AcronymResults.Stub.Proxy(obj);
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
case TRANSACTION_sendResults:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<edu.vuum.mocca.AcronymData> _arg0;
_arg0 = data.createTypedArrayList(edu.vuum.mocca.AcronymData.CREATOR);
this.sendResults(_arg0);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements edu.vuum.mocca.AcronymResults
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
     * This one-way (non-blocking) method allows the
     * AcyronymServiceAsync to return the List of AcronymData results
     * associated with a one-way AcronymRequest.callAcronymRequest()
     * call.
     */
@Override public void sendResults(java.util.List<edu.vuum.mocca.AcronymData> results) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeTypedList(results);
mRemote.transact(Stub.TRANSACTION_sendResults, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
static final int TRANSACTION_sendResults = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
/**
     * This one-way (non-blocking) method allows the
     * AcyronymServiceAsync to return the List of AcronymData results
     * associated with a one-way AcronymRequest.callAcronymRequest()
     * call.
     */
public void sendResults(java.util.List<edu.vuum.mocca.AcronymData> results) throws android.os.RemoteException;
}
