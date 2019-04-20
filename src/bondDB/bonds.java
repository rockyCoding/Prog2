package bondDB;

class bonds{
    String atoms, bondType;         // variables to store atoms bonded and type of bond (single, double or triple bond)
    int bondEnergy;                 // to store bond energy (kJ/mol)
    double bondLength;              // to store bondDB.bonds length (nm)

    // Constructor for a new object of class bondDB.bonds
    public void enterBond(String atoms, String bondType, int bondEnergy, double bondLength){
        this.atoms= atoms;
        this.bondType = bondType;
        this.bondEnergy = bondEnergy;
        this.bondLength = bondLength;
    }

    // get commands for single entries out of bondDB.bonds class object
    public String getAtoms(){
        return atoms;
    }

    public String getBondType(){
        return bondType;
    }

    public int getBondEnergy(){
        return bondEnergy;
    }

    public double getBondLength(){
        return bondLength;
    }

    // get command to get full bond description
    public String getDescription(){
        String description = this.atoms + ", " + this.bondType;
        return description;
    }
}
