package application;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;


public class Algorithm {


    public HashMap<Integer, Integer> getCombination(ArrayList<Integer> category, int num) {
        Stack<StackItems> stack = new Stack<StackItems>();
        ArrayList<StackItems> visited = new ArrayList<StackItems>();
        stack.push(new StackItems(num, null));

        while (true) {
            if (stack.isEmpty()) {
                break;
            }
            StackItems item = stack.pop();
            if (!visited.contains(item)) {
                if (category.contains(item.num)) {
                    return resultMapper(getResultFromParents(item));
                }
                visited.add(item);
            }
            ArrayList<StackItems> newItems = getNewItems(item, category);
            pushStack(stack, newItems);
        }
        return null;
    }

    private HashMap<Integer, Integer> resultMapper(ArrayList<Integer> result) {
        HashMap<Integer, Integer> mapper = new HashMap<Integer, Integer>();
        for (Integer i : result) {
            if (mapper.get(i) == null) {
                mapper.put(i, 0);
            }
            mapper.put(i, mapper.get(i) + 1);
        }
        return mapper;
    }

    private ArrayList<Integer> getResultFromParents(StackItems item) {
        int num = item.num;
        ArrayList<Integer> result = new ArrayList<Integer>();
        while (item.getParents() != null) {
            result.add(item.parents.get(0).num - item.num);
            item = item.getParents().get(0);
        }
        result.add(num);
        return result;
    }

    private void pushStack(Stack<StackItems> stack, ArrayList<StackItems> newItems) {
        for (StackItems newItem : newItems) {
            stack.push(newItem);
        }
    }

    private ArrayList<StackItems> getNewItems(StackItems currentItem, ArrayList<Integer> category) {
        ArrayList<StackItems> newItems = new ArrayList<StackItems>();
        for (Integer i : category) {
            if (currentItem.num > i) {
                ArrayList<StackItems> p = new ArrayList<StackItems>();
                p.add(currentItem);
                newItems.add(new StackItems(currentItem.num - i, p));
            }
        }
        return newItems;
    }


    @Data
    private static class StackItems {
        private int num;
        private ArrayList<StackItems> parents;

        public StackItems(int num, ArrayList<StackItems> parents) {
            this.num = num;
            this.parents = parents;
        }
    }

}
