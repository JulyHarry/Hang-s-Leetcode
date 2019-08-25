package TEST.INTERFACE;

public class interfaceImplement implements interfaceExtends{
    @Override
    public void get() {
        System.out.println("get");
    }

    public void show(){
        System.out.println("show");
    }

    public void set(){
        System.out.println("set");
    }

    public void clear(){
        System.out.println("clear");
    }

    public static void main(String[] args){
        interfaceImplement i = new interfaceImplement();
        i.show();
        i.clear();
    }
}

