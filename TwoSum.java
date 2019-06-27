import java.util.HashMap;
import java.util.Map;

/**
 * @Author huangxiongbiao
 * @Description
 * @Date 2019/6/27 ����1:55
 */
public class TwoSum {



    /**
     * ����һ��������
     * �������ܼ򵥣�����ÿ��Ԫ�� x���������Ƿ����һ��ֵtarget?x ��ȵ�Ŀ��Ԫ�ء�
     *
     * ���Ӷȷ�����
     *  ʱ�临�Ӷȣ�O(n?)
     *  ����ÿ��Ԫ�أ�������ͼͨ��������������ಿ����Ѱ��������Ӧ��Ŀ��Ԫ�أ��⽫�ķ�O(n)��ʱ�䡣
     *  ���ʱ�临�Ӷ�ΪO(n?)��
     *
     *  �ռ临�Ӷ�:  O(1)��
     */
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    /**
     *  �������������ϣ��
     *  Ϊ�˶�����ʱ�临�ӶȽ����Ż���������Ҫһ�ָ���Ч�ķ���������������Ƿ����Ŀ��Ԫ�ء�
     *  ������ڣ�������Ҫ�ҳ��������������������е�ÿ��Ԫ�����������໥��Ӧ����÷�����ʲô����ϣ��
     *  ͨ���Կռ任ȡ�ٶȵķ�ʽ�����ǿ��Խ�����ʱ���O(n) ���͵�O(1)��
     *  ��ϣ������Ϊ��Ŀ�Ķ������ģ���֧���� ���� �㶨��ʱ����п��ٲ��ҡ����á����ơ�������������Ϊһ�����ֳ�ͻ��������ʱ���ܻ��˻���
     *  O(n)����ֻҪ����ϸ����ѡ��ϣ�������ڹ�ϣ���н��в��ҵ���ʱӦ����̯��ΪO(1)��
     *  һ���򵥵�ʵ��ʹ�������ε������ڵ�һ�ε����У����ǽ�ÿ��Ԫ�ص�ֵ������������ӵ����С�Ȼ���ڵڶ��ε����У����ǽ����ÿ��Ԫ������Ӧ��Ŀ��Ԫ�أ�
     * target?nums[i]���Ƿ�����ڱ��С�ע�⣬��Ŀ��Ԫ�ز�����nums[i] ����
     *
     *  ���Ӷȷ�����
     *
     * ʱ�临�Ӷȣ�O(n)��
     * ���ǰѰ�����n ��Ԫ�ص��б�������Ρ����ڹ�ϣ������ʱ�����̵�O(1) ������ʱ�临�Ӷ�ΪO(n)��
     * �ռ临�Ӷȣ�O(n)��
     * ����Ķ���ռ�ȡ���ڹ�ϣ���д洢��Ԫ���������ñ��д洢��n ��Ԫ�ء�
     *
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     *  ��ʵ֤�������ǿ���һ����ɡ��ڽ��е�������Ԫ�ز��뵽���е�ͬʱ�����ǻ���ع�ͷ���������Ƿ��Ѿ����ڵ�ǰԪ������Ӧ��Ŀ��Ԫ�ء�
     *  ��������ڣ��������Ѿ��ҵ��˶�Ӧ�⣬���������䷵�ء�
     *
     *  ���Ӷȷ�����
     *
     * ʱ�临�Ӷȣ�O(n)��
     * ����ֻ�����˰�����n ��Ԫ�ص��б�һ�Ρ��ڱ��н��е�ÿ�β���ֻ����O(1) ��ʱ�䡣
     *
     * �ռ临�Ӷȣ�O(n)��
     * ����Ķ���ռ�ȡ���ڹ�ϣ���д洢��Ԫ���������ñ������Ҫ�洢n ��Ԫ�ء�
     *
     */
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


}
