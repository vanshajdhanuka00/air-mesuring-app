private class SendSensorDataTask extends AsyncTask<String, Void, String> {
    @Override
    protected String doInBackground(String... params) {
        // Send HTTP request to the server and get the response
        // params[0] contains the server URL
        // Handle the response and update UI as needed
        // ...
        return response;
    }

    @Override
    protected void onPostExecute(String result) {
        // Update UI with the received sensor data
        // result contains the response from the server
        // ...
    }
}

// Call this method to send sensor data from the hardware
private void sendSensorDataToServer(String serverUrl) {
    new SendSensorDataTask().execute(serverUrl);
}
