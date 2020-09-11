// Assignment #: 4
// Name        : Brandon
// StudentID   : 
// Lecture     : T/TH 4:30pm - 5:45pm
// Description : Model class uses a combination of mutators and accessor
//               methods to set the attributes for Model Name, CPU speed
//               and the amount of RAM. It is a class used by Laptop Class
//               to store and provide data for Assignment4 class.

import java.text.DecimalFormat;

public class Model 
{
    //Creation of class global variables
    private String modelName;
    private double cpuSpeed = 0.0;
    private int ramSize = 0;
    
    //Decimal Formatter for CPU speed
    private DecimalFormat twoSignificants= new DecimalFormat("0.00");
    
    //Constructor Method
    public Model()
    {
        
    }
    //Get the model name
    public String getModel()
    {
        return modelName;
    }
    //Set a new model name
    public void setModel(String newModel)
    {
        modelName = newModel;
    }
    //Get the CPU speed
    public double getCPU()
    {
        return cpuSpeed;
    }
    //Set a new CPU speed
    public void setCPU(double newCPU)
    {
        cpuSpeed = newCPU;
    }
    //Get the RAM size
    public int getRam()
    {
        return ramSize;
    }
    //Set the RAM size
    public void setRam(int newRAM)
    {
        ramSize = newRAM;
    }
    //Return the information about the Model to the Laptop Class
    public String toString()
    {
        return "Model:\t" + modelName + "\n"
             + "CPU:\t" + twoSignificants.format(cpuSpeed) + "GHz\n"
             + "RAM:\t" + ramSize + "GB\n";
    }
}