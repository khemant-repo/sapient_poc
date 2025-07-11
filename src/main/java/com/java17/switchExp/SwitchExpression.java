package com.java17.switchExp;

public class SwitchExpression {
    public static void main(String[] args) {
        Direction d = Direction.EAST;

        //regularSwitchExp(d);

        System.out.println(switch (d){
            case NORTH,SOUTH ->5;
            default -> 4;
        });

        System.out.println("SE with colon as per regular SE syntax, use yeild "+switch (d){
            case NORTH,SOUTH : yield 5;
            default : yield 4;
        });
    }

    private static void regularSwitchExp(Direction d) {
        int numLetters = 0;
        switch (d){
            case NORTH :
            case SOUTH :
                numLetters = 5;
                break;
            case EAST:
            case WEST:
                numLetters = 4;
                break;
        }
        System.out.println("NUm letter : "+numLetters);
    }
}
