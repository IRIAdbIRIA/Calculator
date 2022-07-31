class Currency {

    private final String name;
    private final double thisToEur;

    Currency (String name, double thisToEur){
        this.name = name;
        this.thisToEur = thisToEur;
    }

    String getName(){
        return name;
    }

    double getThisToEur(){
        return thisToEur;
    }
}
