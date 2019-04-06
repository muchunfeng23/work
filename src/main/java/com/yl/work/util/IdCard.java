package com.yl.work.util;

public class IdCard {
    private String id;
    private static final byte MALE = 1;
    private static final byte FAMALE = 0;
    /**
     * 构造函数初始化
     * @param id
     */
    public IdCard(String id){
        this.id = id;
    }

    /**
     * 检验身份证是否合法
     * @return 1-合法；0-不合法
     */
    public int isLegal(){
        int a = 0;
        int sum = 0;
        char checkBit[]={'1','0','X','9','8','7','6','5','4','3','2'};
        int []add={7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2};
        char []stringArr = id.toCharArray();
        for (int i=0;i<17;i++){
            sum +=add[i]*(stringArr[i]-'0');
        }
        if (stringArr[17]==checkBit[sum%11]){
            a=1;
        }
        return a;
    }

    /**
     * 判断性别
     * @return 1-男；0-女；-1-错误；
     */
    public byte sex(){

        if (isLegal()==1){
            char []stringArr = id.toCharArray();
            if (stringArr[16]%2==0){
                return FAMALE;
            }else{
                return MALE;

            }
        }
        return -1;
    }

    /**
     * 输出年月日
     * @return 年月日的字符串比如：20171207
     */
    public String year(){
        String num=null;
        if (isLegal()==1){
            num = id.substring(6,14);
        }
        return num;
    }
}
