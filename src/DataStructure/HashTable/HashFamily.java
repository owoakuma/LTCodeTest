package DataStructure.HashTable;

public interface HashFamily<AnyType> {
    int hash(AnyType x,int which);
    int getNumberOfFunctions();
    void generalNewFunctions();
}
