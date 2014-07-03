/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /Users/chen/Dropbox/Java/android/POSA-14-master/ex/AcronymApplication/src/edu/vuum/mocca/AcronymRequest.aidl
 */
package edu.vuum.mocca;
/**
 * Interface defining the method that the AcronymServiceAsync will
 * implement to provide asynchronous access to the Acronym Web
 * service.
 */
public interface AcronymRequest extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements edu.vuum.mocca.AcronymRequest
{
private static final java.lang.String DESCRIPTOR = "edu.vuum.mocca.AcronymRequest";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an edu.vuum.mocca.AcronymRequest interface,
 * generating a proxy if needed.
 */
public static edu.vuum.mocca.AcronymRequest asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof edu.vuum.mocca.AcronymRequest))) {
return ((edu.vuum.mocca.AcronymRequest)iin);
}
return new edu.vuum.mocca.AcronymRequest.Stub.Proxy(obj);
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
edu.vuum.mocca.AcronymResults _arg0;
_arg0 = edu.vuum.mocca.AcronymResults.Stub.asInterface(data.readStrongBinder());
java.lang.String _arg1;
_arg1 = data.readString();
this.expandAcronym(_arg0, _arg1);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements edu.vuum.mocca.AcronymRequest
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
    * A one-way (non-blocking) call to the AcronymServiceAsync that
    * retrieves information about an acronym from the Acronym Web
    * service.  The AcronymServiceAsync subsequently uses the
    * AcronymResults parameter to return a List of AcronymData
    * containing the results from the Web service back to the
    * AcronymActivity.
    */
@Override public void expandAcronym(edu.vuum.mocca.AcronymResults results, java.lang.String acronym) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((results!=null))?(results.asBinder()):(null)));
_data.writeString(acronym);
mRemote.transact(Stub.TRANSACTION_expandAcronym, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
static final int TRANSACTION_expandAcronym = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
/**
    * A one-way (non-blocking) call to the AcronymServiceAsync that
    * retrieves information about an acronym from the Acronym Web
    * service.  The AcronymServiceAsync subsequently uses the
    * AcronymResults parameter to return a List of AcronymData
    * containing the results from the Web service back to the
    * AcronymActivity.
    */
public void expandAcronym(edu.vuum.mocca.AcronymResults results, java.lang.String acronym) throws android.os.RemoteException;
}
