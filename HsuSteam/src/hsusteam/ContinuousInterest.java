/*
Caroline Hsu - 04/05/2021
This class calculates continuous interest and is encapsulated with get
and set methods. It has two constructors and has a toString method
and one example object to test the constructor.
 */
package hsusteam;

public class ContinuousInterest 
{
  // private datafields/attributes
  private double principal;
  private int years;
  private double rate;
  private double result;
  private double exponent;
  
  // first constructor with values from other class
  public ContinuousInterest(double principalOne, double rateOne, int yearsOne)
  {
    // get values from other input class and assign them to this one
    this.principal = principalOne;
    this.years = yearsOne;
    this.rate = rateOne;
    
    // complete calculation and set it to result
    this.exponent = this.rate * this.years;
    this.result = Math.exp(this.exponent);
    this.result = this.result * this.principal;
    
    // automatic round to two decimal places because monetary values
    // are of 2 decimal places
    this.result = 100 * this.result;
    this.result = Math.round(this.result);
    this.result = this.result / 100;
  }
  
  // accessors/getters for encapsulation
  public double getPrincipal()
  {
    return this.principal;
  }
  public int getYears()
  {
    return this.years;
  }
  public double getRate()
  {
    return this.rate;
  }
  public double getExponent()
  {
    return this.exponent;
  }
  public double getResult()
  {
    return this.result;
  }
  
  // mutators/setters for encapsulation
  public void setPrincipal(double principal)
  {
    this.principal = principal;
  }
  public void setYears(int years)
  {
    this.years = years;
  }
  public void setRate(double rate)
  {
    this.rate = rate;
  }
  public void setExponent(double exponent)
  {
    this.exponent = exponent;
  }
  public void setResult(double result)
  {
    this.result = result;
  }
  
  // override toString with all components (principal, years, decimal rate,
  //  and result)
  @Override
  public String toString()
  {
    // string with the answer and it returns it 
    String answer = "The continuous interest from principal amount " 
                    + this.principal + " dollars, " + this.years  
                    + " years, "  + " and a rate of " + this.rate 
                    + " equals " + this.result;
    return answer;
  }
  
  public static void main (String[] args)
  {
    // main method construct the example object
    ContinuousInterest example = new ContinuousInterest(120.42, 0.03, 5);
    // use the toString to print the answer
    System.out.println(example);
  }
}
