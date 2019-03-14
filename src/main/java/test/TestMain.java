package test;

/**
 * Created by weixiaolong on 2019/1/14.
 */
public class TestMain {
    public static void main(String... args) {
        MyLinkList myLinkList = new MyLinkList();
        MyLinkList.LinkNode linkNode = new MyLinkList.LinkNode(1);
        linkNode.next = new MyLinkList.LinkNode(2);
        linkNode.next.next = new MyLinkList.LinkNode(3);
        linkNode.next.next.next = new MyLinkList.LinkNode(3);
        linkNode.next.next.next.next = new MyLinkList.LinkNode(4);
        linkNode.next.next.next.next.next = new MyLinkList.LinkNode(5);
        linkNode.next.next.next.next.next.next = new MyLinkList.LinkNode(4);
        linkNode.next.next.next.next.next.next.next = new MyLinkList.LinkNode(4);
        linkNode.next.next.next.next.next.next.next.next = new MyLinkList.LinkNode(5);
//        myLinkList.links = linkNode;
        myLinkList.deleteInt(4);
        myLinkList.print();
        System.out.println();
        myLinkList.add(6);
        myLinkList.print();
    }


}


class MyLinkList {

    LinkNode links;

    public void print() {
        LinkNode root = links;
        while (root != null) {
            System.out.print(root.val + "  ");
            root = root.next;
        }
    }

    public void deleteInt(int val) {
        LinkNode root = links;
        if(links == null){
            //null;
            return;
        }
        while (root.val == val) {
            links = root.next;
            root = links;
        }
        LinkNode cur = root.next;
        LinkNode next = null;
        while (cur != null) {
            next = cur.next;
            if (cur.val == val) {
                root.next = next;
                cur.next = null;

                cur = next;
                root = root;
            } else {
                root = cur;//root.next;
                cur = next;
            }
        }
    }

    public void add(int val) {
        LinkNode root = links;
        if(links == null){
            links = new LinkNode(val);
            return;
        }
        //首位
        if (root.val > val) {
            links = new LinkNode(val);
            links.next = root;
            return;
        }
        while (root != null) {
            if (root.next != null) {
                if (root.val <= val && val < root.next.val) {
                    LinkNode temp = new LinkNode(val);
                    LinkNode next = root.next;
                    root.next = temp;
                    temp.next = next;
                    return;
                }
            } else {
                root.next = new LinkNode(val);
                return;
            }
            root = root.next;
        }
    }

    static class LinkNode {

        LinkNode next;
        int val;

        public LinkNode(int val) {
            this.val = val;
        }

        public LinkNode getNext() {
            return next;
        }

        public void setNext(LinkNode next) {
            this.next = next;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }
    }
}
