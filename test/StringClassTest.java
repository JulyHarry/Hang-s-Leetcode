//import org.junit.Assert;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class StringClassTest {
//
//    @Test
//    void repeatedSubstringPattern1() {
//        StringClass stringClass = new StringClass();
//        boolean res1 = stringClass.repeatedSubstringPattern1("abab");
//        Assert.assertEquals(res1, true);
//        boolean res2 = stringClass.repeatedSubstringPattern1("ababa");
//        Assert.assertEquals(res2, false);
//        boolean res3 = stringClass.repeatedSubstringPattern1("abcabcabc");
//        Assert.assertEquals(res3, true);
//        boolean res4 = stringClass.repeatedSubstringPattern1("abcabcaabcabca");
//        Assert.assertEquals(res4, true);
//        boolean res5 = stringClass.repeatedSubstringPattern1("abldlbakdf");
//        Assert.assertEquals(res5, false);
//    }
//
//    @Test
//    void repeatedSubstringPattern2() {
//        StringClass stringClass = new StringClass();
//        boolean res1 = stringClass.repeatedSubstringPattern2("ab");
//        Assert.assertEquals(res1, false);
//        boolean res2 = stringClass.repeatedSubstringPattern2("ababa");
//        Assert.assertEquals(res2, false);
//        boolean res3 = stringClass.repeatedSubstringPattern2("abcabcabc");
//        Assert.assertEquals(res3, true);
//        boolean res4 = stringClass.repeatedSubstringPattern2("abcabcaabcabca");
//        Assert.assertEquals(res4, true);
//        boolean res5 = stringClass.repeatedSubstringPattern2("abldlbakdf");
//        Assert.assertEquals(res5, false);
//    }
//
//    @Test
//    void reverseWords() {
//        StringClass stringClass = new StringClass();
//        String s = "Let's take LeetCode contest";
//        Assert.assertEquals(stringClass.reverseWords(s), "s'teL ekat edoCteeL tsetnoc");
//        s = "  Have a    good    day.  ";
//        Assert.assertEquals(stringClass.reverseWords(s),"evaH a doog .yad");
//    }
//}