//package com.teamproject.functions;
//
//import android.app.AlertDialog;
//import android.app.Service;
//import android.content.Context;
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.location.Location;
//import android.location.LocationListener;
//import android.location.LocationManager;
//import android.os.Bundle;
//import android.os.IBinder;
//import android.provider.Settings;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import com.teamproject.models.GPSDTO;
//
//public class GPStracker extends Service implements LocationListener{
//
//	private Context context;
//
//	boolean isGPSEnabled = false;
//	boolean canGetLocation = false;
//	boolean isNetworkEnabled = false;
//	GPSDTO gpsdto = new GPSDTO();
//	Location location;
//
//	double latitude;
//	double longitude;
//
//	private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 0;
//	private static final long MIN_TIME_BW_UPDATES = 2000;
//
//	protected LocationManager locationManager;
//
//	public GPStracker(Context context){
//		this.context = context;
//		getLocation();
//	}
//
//	public Location getLocation(){
//		try {
//			locationManager = (LocationManager) context.getSystemService(LOCATION_SERVICE);
//			isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
//			isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
//
//			if(!isGPSEnabled && !isNetworkEnabled){
//
//			}
//			else {
//				this.canGetLocation = true;
//
//				if(isNetworkEnabled){
//					locationManager.requestLocationUpdates(
//							LocationManager.NETWORK_PROVIDER,
//							MIN_TIME_BW_UPDATES,
//							MIN_DISTANCE_CHANGE_FOR_UPDATES,
//							this);
//
//				if(locationManager != null ){
//					location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
//
//					if (location != null){
//						latitude = location.getLatitude();
//						longitude = location.getLongitude();
//					}
//				}
//				}
//
//				if(isGPSEnabled){
//					if(location == null){
//						locationManager.requestLocationUpdates(
//								LocationManager.GPS_PROVIDER,
//								MIN_TIME_BW_UPDATES,
//								MIN_DISTANCE_CHANGE_FOR_UPDATES,
//								this);
//
//						if(locationManager != null){
//							location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
//
//							if (location != null){
//								latitude = location.getLatitude();
//								longitude  = location.getLongitude();
//
//							}
//						}
//					}
//				}
//			}
//		}
//		catch (Exception e){
//			e.printStackTrace();
//		}
//		return location;
//	}
//
//	public void stopUsingGPS(){
//		if (locationManager != null)
//		{
//			locationManager.removeUpdates(GPStracker.this);
//		}
//	}
//
//	public double getLatitude(){
//		if(location!=null){
//			latitude  = location.getLatitude();
//		}
//		return latitude;
//	}
//
//	public double getLongitude(){
//		if(location!=null){
//			longitude  = location.getLongitude();
//		}
//		return longitude;
//	}
//
//	public boolean canGetLocation()
//	{
//		return this.canGetLocation;
//	}
//	public void showSettingAlert()
//	{
//		AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
//		alertDialog.setTitle("GPS");
//		alertDialog.setMessage("GPS jest wyłączony. Chcesz przejść do ustawień?");
//		alertDialog.setPositiveButton("Tak", new DialogInterface.OnClickListener() {
//
//			@Override
//			public void onClick(DialogInterface dialog, int which) {
//				Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
//				context.startActivity(intent);
//			}
//		});
//		alertDialog.setNegativeButton("Nie", new DialogInterface.OnClickListener() {
//			@Override
//			public void onClick(DialogInterface dialog, int which) {
//				dialog.cancel();
//			}
//		});
//		alertDialog.show();
//	}
//	@Override
//	public void onLocationChanged(Location location) {
//		// TODO Auto-generated method stub
//		latitude = location.getLatitude();
//		longitude  = location.getLongitude();
//		gpsdto.setDlugosc(longitude);
//		gpsdto.setSzerokosc(latitude);
//	}
//
//	@Override
//	public void onStatusChanged(String provider, int status, Bundle extras) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void onProviderEnabled(String provider) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void onProviderDisabled(String provider) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public IBinder onBind(Intent intent) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//}
