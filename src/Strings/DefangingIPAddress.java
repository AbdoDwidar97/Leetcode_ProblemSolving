package Strings;

public class DefangingIPAddress
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.defangIPaddr("1.1.1.1"));
    }

    private static class Solution
    {
        public String defangIPaddr(String address)
        {
            return address.replace(".", "[.]");
        }
    }
}
