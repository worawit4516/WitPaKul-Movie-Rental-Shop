package lib.service;
import lib.item.Item;

public interface MemberService {
    public abstract ItemLending checkoutItem(MemberAccount member, Item borrowBook);
    public abstract int checkForFine(MemberAccount member, ItemLending borrowItem);
    public abstract boolean returnItem(MemberAccount member, ItemLending returnItem);
    public abstract ItemLending[] getMyLendingList(MemberAccount member);
}
