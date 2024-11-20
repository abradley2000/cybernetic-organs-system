package com.cybernetic;

import java.util.ArrayList;
import java.util.List;

public class SystemOperationsLog {
    SystemOperation[] stackArray;
    int top;

    public SystemOperationsLog(int size) {
        stackArray = new SystemOperation[size];
        top = -1;
    }

    public void pushOperation(SystemOperation systemOperation) {
        stackArray[++top] = systemOperation;
    }

    public SystemOperation popLastOperation() {
        return stackArray[top--];
    }

    public SystemOperation peekLastOperation() {
        return stackArray[top];
    }

    // I don't understand what it means to "undo" an operation, all I see is that an operation can/can't be reversible
    /*
    public void undoLastOperation() {
        if (stackArray[top].getIsReversible()) ???
    }
     */

    public List<SystemOperation> getRecentOperations(int count) {
        List<SystemOperation> result = new ArrayList<>();
        for (int i = 0; i < Math.min(count, top + 1); i++) {
            result.add(stackArray[top - i]);
        }
        return result;
    }
}
