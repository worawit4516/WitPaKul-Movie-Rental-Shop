package lib.service;

import lib.item.Item;

public class BookLending extends ItemLending {

    @Override
    ItemLending checkoutItem(Item borrowItem, MemberAccount lendingMember) {
        ItemLending il = super.checkoutItem(borrowItem, lendingMember);
        lendingMember.checkoutItem(il);
        return il;
    }

    @Override
    int returnItem(MemberAccount lendingMember) {
        int fine = super.returnItem(lendingMember);
        lendingMember.returnItem(this, fine);
        return fine;
    }

}
