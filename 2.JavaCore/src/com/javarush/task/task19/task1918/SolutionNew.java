package com.javarush.task.task19.task1918;

import java.util.Comparator;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/**
 * Created by USER-PC on 04.10.2017.
 *
 */
public class SolutionNew {
    public static void main(String[] args){
    String content = "<span>text1</span>\\n\" +\n" +
            "\"<span text2>text1</span>\\n\" +\n" +
            "\"<span\\n\" +\n" +
            "\"text2>text1</span> Хрень которой быть не должно <spanline>Этой строки быть не должно</spanline>\" +\n" +
            "\"даже если тут написать <span> это будет /span целиком </span> tag между /span\" +\n" +
            "\"Info about Leela <span xml:lang=»en» lang=»en»><b><span>Turanga Leela\\n\" +\n" +
            "\"</span></b></span><span>Super</span><span>girl</span>";
    StringBuffer text = new StringBuffer(content.replaceAll("\r\n", ""));

    String tagOpen = "<" + args[0];
    String tagClose = "</" + args[0] + ">";

    int pozitionOpen = -1;
    int pozitionClose = -1;
    int shift = -1;
    Stack<Integer> openedTags = new Stack<>();
    Map<Integer, Integer> tags = new TreeMap<>(new MyComparator());
        while (true) {
        pozitionOpen = text.indexOf(tagOpen, shift);
        pozitionClose = text.indexOf(tagClose, shift);
        if (pozitionOpen < 0 && pozitionClose < 0)
            break;

        if (pozitionOpen != -1 && pozitionOpen < pozitionClose) { //Open ближе чем close
            openedTags.push(pozitionOpen);
            shift = pozitionOpen + tagOpen.length();
            continue;
        }

        if (pozitionClose != -1 && (pozitionOpen > pozitionClose || pozitionOpen == -1)) { //Close ближе чем open
            if (openedTags.isEmpty())
                break;
            tags.put(openedTags.pop(), pozitionClose + tagClose.length());
            shift = pozitionClose + tagClose.length();
        }
    }

        for (Map.Entry<Integer, Integer> pair : tags.entrySet()) {
        System.out.println(text.substring(pair.getKey(), pair.getValue()));
    }
}

static class MyComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer a, Integer b) {
        return a.compareTo(b);
    }

}}
