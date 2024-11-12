package utils;

public class SystemExitHandler implements ExitHandler{
    @Override
    public void exit(int status){
        System.exit(status);
    }
}
