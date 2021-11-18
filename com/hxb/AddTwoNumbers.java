package com.hxb;

/**
 * @Author huangxiongbiao
 * @Description
 * @Date 2019/6/27 ����2:33
 */
public class AddTwoNumbers {


    /**
     * ������������ѧ
     *
     * ˼·
     *
     * ����ʹ�ñ��������ٽ�λ�����Ӱ��������Чλ�ı�ͷ��ʼģ����λ��ӵĹ��̡�
     *
     * ͼ1����������ӷ����Ŀ��ӻ�:
     * 342+465=807��ÿ����㶼����һ�����֣��������ְ�λ����洢��
     *
     * �㷨
     *
     * ��������ֽ�ϼ����������ֵĺ��������������ȴ������ЧλҲ�����б�
     * l1 �� l2 �ı�ͷ��ʼ��ӡ�����ÿλ���ֶ�Ӧ������
     * 0��9 �ķ�Χ�ڣ����Ǽ����������ֵĺ�ʱ���ܻ���� ������������磬
     * 5+7=12������������£����ǻὫ��ǰλ����ֵ����Ϊ2��������λ
     * carry=1 ������һ�ε�������λcarry �ض���0 �� 1��������Ϊ����������ӣ����ǵ���λ�����ܳ��ֵ�����Ϊ
     * 9+9+1=19��
     *
     * α�������£�
     *
     * ����ǰ����ʼ��Ϊ�����б���ƽ�㡣
     * ����λcarry ��ʼ��Ϊ0��
     * ��p �� q �ֱ��ʼ��Ϊ�б�l1 �� l2 ��ͷ����
     * �����б�l1 �� l2 ֱ���������ǵ�β�ˡ�
     * ��x ��Ϊ���p ��ֵ�����p �Ѿ�����l1 ��ĩβ������ֵ����Ϊ0��
     * ��y ��Ϊ���q ��ֵ�����q �Ѿ�����l2 ��ĩβ������ֵ����Ϊ0��
     * �趨sum=x+y+carry��
     * ���½�λ��ֵ��carry=sum/10��
     * ����һ����ֵΪ(summod10) ���½�㣬����������Ϊ��ǰ������һ����㣬Ȼ�󽫵�ǰ���ǰ������һ����㡣
     * ͬʱ����
     * p �� q ǰ������һ����㡣
     * ���carry=1 �Ƿ������������������򷵻��б�׷��һ����������1 ���½�㡣
     * �����ƽ�����һ����㡣
     * ��ע�⣬����ʹ���ƽ�����򻯴��롣���û���ƽ�㣬������д����������������ʼ����ͷ��ֵ��
     *
     * ���ر�ע�����������
     *
     * ��������	˵��
     * l1=[0,1]��l2=[0,1,2]	��һ���б����һ���б�ʱ
     * l1=[]��l2=[0,1]	��һ���б�Ϊ��ʱ�������ֿ��б�
     * l1=[9,9]�� l2=[1]	������������ܳ��ֶ���Ľ�λ����һ������ױ�����
     *
     *
     * ���Ӷȷ���
     *
     * ʱ�临�Ӷȣ�
     * O(max(m,n))������m �� n �ֱ��ʾl1 �� l2 �ĳ��ȣ�������㷨����ظ�max(m,n) �Ρ�
     *
     * �ռ临�Ӷȣ�
     * O(max(m,n))�� ���б�ĳ������Ϊmax(m,n)+1��
     *
     * ��չ
     *
     * ��������е����ֲ��ǰ�����洢���أ����磺
     * (3��4��2)+(4��6��5)=8��0��7
     *
     * �ҷ��� �������������֮��������
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseListNode(ListNode node) {
        ListNode pre = null;
        ListNode next = null;
        while (node != null) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }


}
