package dxg_single;
// 枚举类型线程安全的单列方式
public enum SingleDemo5 {
    instance("第一个实例"),intacne2("第二个实例");

    private SingleDemo5 (String name){
        this.name = name;
    }
    private String name ;
    public String getName(){
        return  name;
    }
}
