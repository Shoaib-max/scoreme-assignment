# Task 2 — ConcurrentModificationException Analysis

### 1. Cause of ConcurrentModificationException
ConcurrentModificationException occurs when a collection is modified while it is being iterated using an iterator (e.g., for-each loop).

---

### 2. Problematic Code Pattern
Most likely pattern at line 142:

for (Transaction t : transactions) {
    if (condition) {
        transactions.remove(t);   // causes exception
    }
}

---

### 3. Minimal Fix

Use iterator remove:

Iterator<Transaction> it = transactions.iterator();
while (it.hasNext()) {
    Transaction t = it.next();
    if (condition) {
        it.remove();   // safe removal
    }
}
