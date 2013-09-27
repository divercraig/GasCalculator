package uk.co.craigwarren.gascalc.model;

public class Cylinder {
	
	private double volume;
	private double pressure;
	private Gas gas;
	private double ambientTemperatureKelvin;
	
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
	public double getPressure() {
		return pressure;
	}
	public void setPressure(double pressure) {
		this.pressure = pressure;
	}
	public Gas getGas() {
		return gas;
	}
	public void setGas(Gas gas) {
		this.gas = gas;
	}
	
	public Cylinder(double volume, double pressure, Gas gas) {
		this.volume = volume;
		this.pressure = pressure;
		this.gas = gas;
	}
	
	public Cylinder(double volume, double pressure) {
		this(volume, pressure, Gas.air());
	}
	
	public Cylinder(double volume) {
		this(volume, 0);
	}
    public double getAmbientTemperatureKelvin() {
        return ambientTemperatureKelvin;
    }
    public void setAmbientTemperatureKelvin(double ambientTemperatureKelvin) {
        this.ambientTemperatureKelvin = ambientTemperatureKelvin;
    }

}
