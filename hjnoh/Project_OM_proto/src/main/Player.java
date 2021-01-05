package main;

import java.util.Arrays;

public class Player {
    private String name;
    //스탯 5개(잠,공복,체력,체온,부상)를 그냥 int배열로 만들어버림
    private int[] status = new int[5];
    private int[] items = new int[5]; // 아이템 id를 번호로 구분할 생각..(최대5개)

    // 이걸 쓰다보니까 생각난건데
    // 바로바로 아이템 넣고빼고 스탯 변화하는게 UI에 적용되려면 리액티브 프로그래밍을 해야 하는 게 아닌가?!
    // 그래서 찾아봤더니 정말로 리액티브 자바fx 라이브러리가 있었으나.. 뭔가 새로 또 파야 한다는 것이
    // 원먼쓰(OM)안에는 어려울 것 같다는 생각이 들어
    // 그냥 이벤트 핸들러로 화면에서는 대충 변하는 척만 하고 실제로 변하는 건 다음씬으로 넘어가게 하면 가능할 것 같다는 생각..
    // 근데 또 이렇게 하면 모든 버튼별로 액션핸들러가 필요하니까.. 씬별로 컨트롤러가 생기는 처참한 상황이..
    // 이따가 민영쓰랑 얘기해봐야겠구만

    public void setName(String name){
        this.name = name;
    }
    public void setStatus(int[] status){
        this.status = Arrays.copyOf(status,status.length);
    }
    public void setItems(int[] items){
        this.items = Arrays.copyOf(items,items.length);
    }

    public String getName(){
        return name;
    }
    public int[] getStatus(){
        return Arrays.copyOf(status,status.length);
    }
    public int[] getItems(){
        return Arrays.copyOf(items,items.length);
    }

    public Player(String name, int[] status, int[] items){
        this.name = name;
        this.status = Arrays.copyOf(status,status.length);
        this.items = Arrays.copyOf(items,items.length);
    }



}

