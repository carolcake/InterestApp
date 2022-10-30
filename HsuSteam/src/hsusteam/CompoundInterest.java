/*
Caroline Hsu - 04/05/2021
This class calculates compound interest and is encapsulated with get
and set methods. It has two constructors and has a toString method
and one example object to test the constructor.
 */
package hsusteam;

public class CompoundInterest 
{
  // private datafields/attributes
  private double principal;
  private int years;
  private int timesCompounded;
  private double rate;
  private double result;
  private double parentheses;
  private double exponent;
  
  // first constructor with values from other class
  public CompoundInterest(double principalOne, int yearsOne, 
                          int timesCompoundedOne, double rateOne)
  {
    // get values from other input class and assign them to this one
    this.principal = principalOne;
    this.years = yearsOne;
    this.timesCompounded = timesCompoundedOne;
    this.rate = rateOne;
    
    // complete calculation and set it to result
    this.parentheses = this.rate / this.timesCompounded;
    this.parentheses = 1 + this.parentheses;
    this.exponent = this.timesCompounded * this.years;
    this.result = Math.pow(this.parentheses, this.exponent);
    this.result = this.principal * this.result;
    
    // automatic round to two decimal places because monetary values
    // are of 2 decimal places
    this.result = 100 * this.result;
    this.result = Math.round(this.result);
    this.result = this.result / 100;
  }
  
  // second constructor overloads original
  public CompoundInterest()
  {
    this.principal = 0;
    this.years = 0;
    this.timesCompounded = 0;
    this.rate = 0;
    
    this.parentheses = this.rate / this.timesCompounded;
    this.parentheses = 1 + this.parentheses;
    this.exponent = this.timesCompounded * this.years;
    this.result = Math.pow(this.parentheses, this.exponent);
    this.result = this.principal * this.result;
    this.result = 100 * this.result;
    Math.round(this.result);
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
  public int getTimesCompounded()
  {
    return this.timesCompounded;
  }
  public double getRate()
  {
    return this.rate;
  }
  public double getParentheses()
  {
    return this.parentheses;
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
  public void setTimesCompounded(int timesCompounded)
  {
    this.timesCompounded = timesCompounded;
  }
  public void setRate(double rate)
  {
    this.rate = rate;
  }
  public void setParentheses(double parentheses)
  {
    this.parentheses = parentheses;
  }
  public void setExponent(double exponent)
  {
    this.exponent = exponent;
  }
  public void setResult(double result)
  {
    this.result = result;
  }
  
  // override toString with all components (principal, years, times compounded,
  // decimal rate, and result)
  @Override
  public String toString()
  {
    // string with the answer and it returns it 
    String answer = "The compound interest from principal amount " 
                    + this.principal + " dollars, " + this.years  
                    + " years, " + this.timesCompounded + " times compounded, " 
                    + "and a rate of " + this.rate + " equals " + this.result;
    return answer;
  }
  
  public static void main (String[] args)
  {
    // main method construct the example object
    CompoundInterest example = new CompoundInterest(200.50, 4, 12, 0.05);
    // use the toString to print the answer
    System.out.println(example);
  }
  
}
