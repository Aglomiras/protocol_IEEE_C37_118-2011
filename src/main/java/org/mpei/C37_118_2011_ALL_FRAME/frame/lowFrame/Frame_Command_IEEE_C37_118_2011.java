package org.mpei.C37_118_2011_ALL_FRAME.frame.lowFrame;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
/**---------------------------------------------------------------------------------------------------------------------
 * Класс определяющий структуру кадра Command protocol IEEE C37.118-2011------------------------------------------------
 * ---------------------------------------------------------------------------------------------------------------------
 * */
public class Frame_Command_IEEE_C37_118_2011 {
    /**
     * -----------------------------------------------------------------------------------------------------------------
     * Команда----------------------------------------------------------------------------------------------------------
     * -----------------------------------------------------------------------------------------------------------------
     */
    private short command;                                                                             //Размер: 2 байта

    /**
     * -----------------------------------------------------------------------------------------------------------------
     * Метод для представления информации в человекочитаемом виде-------------------------------------------------------
     * -----------------------------------------------------------------------------------------------------------------
     */
    @Override
    public String toString() {
        return "\t\tFrame Command [IEEE_C37_118_2011] {" + "\n" +
                "\t\t\tcommand: " + addZero(Integer.toBinaryString(command), 16) + "\n" +
                "\t\t}" + "\n";
    }

    /**
     * -----------------------------------------------------------------------------------------------------------------
     * Метод по добавлению нулей в бинарное представление числа---------------------------------------------------------
     * -----------------------------------------------------------------------------------------------------------------
     */
    public static String addZero(String bits, int sizeByte) {
        if (bits.length() < sizeByte) {
            StringBuilder strBuilder = new StringBuilder(bits);
            for (int i = 0; i < sizeByte - bits.length(); i++) {
                strBuilder.insert(0, "0");
            }
            return strBuilder.toString();
        } else {
            return bits;
        }
    }
}
