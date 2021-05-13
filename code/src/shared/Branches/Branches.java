package shared.Branches;

import client.exceptions.DoesNotExist;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Branches {
    private List<Branch> branches;
    private static Branches instance;
    private static Lock lock = new ReentrantLock();

    private Branches() {
        branches = new ArrayList<>();
    }

    public static Branches getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null)
                    instance = new Branches();
            }
        }
        return instance;
    }

    public Branch getBranch(String name) throws DoesNotExist {
        for (Branch branch : branches) {
            if (branch.getName().equals(name))
                return branch;
        }
        throw new DoesNotExist("couldn't find the right branch");
    }

    public void add(Branch branch) {
        branches.add(branch);
    }

}
