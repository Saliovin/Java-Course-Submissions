
public class RegistrationPlate {
    // don't change the code which is already given to you

    // ATTENTION: the object variable types are final, meaning that their value cannot be changed!
    private final String regCode;
    private final String country;

    public RegistrationPlate(String country, String regCode) {
        this.regCode = regCode;
        this.country = country;
    }

    @Override
    public String toString() {
        return country + " " + regCode;
    }

    @Override
    public int hashCode() {
        if(regCode == null || country == null) {
            return 8;
        }
        return regCode.hashCode() + country.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        
        if(this.getClass() != obj.getClass()) {
            return false;
        }
        
        RegistrationPlate compared = (RegistrationPlate)obj;
        
        if(this.country.equals(compared.country) && 
                this.regCode.equals(compared.regCode)) {
            return true;
        }
        
        return false;
    }
}
