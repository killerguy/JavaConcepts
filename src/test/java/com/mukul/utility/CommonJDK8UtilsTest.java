package com.mukul.utility;

import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;

import static org.junit.Assert.*;


public class CommonJDK8UtilsTest {

    @Test
    public void gcd_of_array_containing_1_to_5_is_1()  {
        OptionalInt gcd = CommonJDK8Utils.gcd(new int[]{1, 2, 3, 4, 5});
        assertNotNull(gcd);
        assertEquals(1, gcd.getAsInt());
    }

    @Test
    public void gcd_of_array_containing_4_8_and_12_is_4()  {
        OptionalInt gcd = CommonJDK8Utils.gcd(new int[]{4, 8, 12});
        assertNotNull(gcd);
        assertEquals(4, gcd.getAsInt());
    }

    @Test
    public void lcm_of_array_containing_1_to_5_is_60()  {
        OptionalInt lcm = CommonJDK8Utils.lcm(new int[]{1, 2, 3, 4, 5});
        assertNotNull(lcm);
        assertEquals(60, lcm.getAsInt());
    }

    @Test
    public void lcm_of_array_containing_4_8_and_12_is_24()  {
        OptionalInt lcm = CommonJDK8Utils.lcm(new int[]{4, 8, 12});
        assertNotNull(lcm);
        assertEquals(24, lcm.getAsInt());
    }

    @Test
    public void max_of_array_containing_10_1_and_5_is_10()  {
        OptionalInt max = CommonJDK8Utils.arrayMax(new int[]{10, 1, 5});
        assertEquals(10, max.getAsInt());
    }

    @Test
    public void min_of_array_containing_10_1_and_5_is_10()  {
        OptionalInt min = CommonJDK8Utils.arrayMin(new int[]{10, 1, 5});
        assertEquals(1, min.getAsInt());
    }

    @Test
    public void countOccurrences_counts_occurrences_of_a_value()  {
        long count = CommonJDK8Utils.countOccurrences(new int[]{1, 1, 2, 1, 2, 3}, 1);
        assertEquals(3, count);
    }

    @Test
    public void deepFlatten_flatten_a_deeply_nested_array()  {
        int[] flatten = CommonJDK8Utils.deepFlatten(
                new Object[]{1, new Object[]{2}, new Object[]{3, 4, 5}}
        );

        System.out.println(Arrays.toString(flatten));
    }

    @Test
    public void difference_between_array_with_1_2_3_and_array_with_1_2_4_is_3()  {
        int[] difference = CommonJDK8Utils.difference(new int[]{1, 2, 3}, new int[]{1, 2, 4});
        System.out.println(Arrays.toString(difference));

    }

    @Test
    public void difference_between_array_with_1_2_3_and_array_with_1_2_3_is_empty_array()  {
        int[] difference = CommonJDK8Utils.difference(new int[]{1, 2, 3}, new int[]{1, 2, 3});
        assertEquals(0, Arrays.stream(difference).count());
    }

    @Test
    public void differenceWith_return_all_squares_that_do_not_exist_in_second()  {
        int[] difference = CommonJDK8Utils.differenceWith(
                new int[]{1, 4, 9, 16, 25},
                new int[]{1, 2, 3, 6, 7},
                (o1, o2) -> o1 - (o2 * o2)
        );

        System.out.println(Arrays.toString(difference));
    }

    @Test
    public void differenceWith_returns_empty_array_when_two_arrays_are_equal_as_per_comparison_operation()  {
        int[] difference = CommonJDK8Utils.differenceWith(
                new int[]{1, 2, 3},
                new int[]{1, 2, 3},
                (o1, o2) -> o1 - o2
        );

        assertEquals(0, Arrays.stream(difference).count());
    }

    @Test
    public void differenceWith_returns_first_array_when_elements_in_second_array_are_not_comparable_as_per_comparison_operation()  {
        int[] difference = CommonJDK8Utils.differenceWith(
                new int[]{1, 2, 3},
                new int[]{10, 11, 12},
                (o1, o2) -> o1 - o2
        );

        System.out.println(Arrays.toString(difference));
    }

    @Test
    public void distinct_remove_all_duplicate_values_from_an_array()  {
        int[] distinct = CommonJDK8Utils.distinctValuesOfArray(new int[]{1, 2, 2, 3, 4, 4, 5});
        System.out.println(Arrays.toString(distinct));
    }

    @Test
    public void drop_elements_less_than_3()  {
        int[] elements = CommonJDK8Utils.dropElements(new int[]{1, 2, 3, 4}, i -> i >= 3);
        System.out.println(Arrays.toString(elements));
    }

    @Test
    public void drop_elements_returns_empty_array_when_no_element_match_the_condition()  {
        int[] elements = CommonJDK8Utils.dropElements(new int[]{1, 2, 3, 4}, i -> i < 1);
        assertEquals(0, elements.length);
    }

    @Test
    public void drop_elements__return_all_elements_when_all_elements_match_the_condition()  {
        int[] elements = CommonJDK8Utils.dropElements(new int[]{1, 2, 3, 4}, i -> i <= 4);
        System.out.println(Arrays.toString(elements));
    }

    @Test
    public void dropRight_remove_n_elements_from_right()  {
        int[] elements = CommonJDK8Utils.dropRight(new int[]{1, 2, 3}, 1);
        System.out.println(Arrays.toString(elements));

        elements = CommonJDK8Utils.dropRight(new int[]{1, 2, 3}, 2);
        System.out.println(Arrays.toString(elements));

        elements = CommonJDK8Utils.dropRight(new int[]{1, 2, 3}, 3);
        assertNotNull(elements);

        elements = CommonJDK8Utils.dropRight(new int[]{1, 2, 3}, 42);
        assertNotNull(elements);
    }

    @Test
    public void everyNth_return_every_2nd_element()  {
        int[] elements = CommonJDK8Utils.everyNth(new int[]{1, 2, 3, 4, 5, 6}, 2);
        System.out.println(Arrays.toString(elements));
    }

    @Test
    public void filterNonUnique_return_unique_elements()  {
        int[] elements = CommonJDK8Utils.filterNonUnique(new int[]{1, 2, 2, 3, 4, 4, 5});
        System.out.println(Arrays.toString(elements));
    }

    @Test
    public void filterNonUnique_return_same_array_when_all_unique()  {
        int[] elements = CommonJDK8Utils.filterNonUnique(new int[]{1, 2, 3, 4, 5});
        System.out.println(Arrays.toString(elements));
    }

    @Test
    public void filterNonUnique_return_empty_array_when_all_duplicated()  {
        int[] elements = CommonJDK8Utils.filterNonUnique(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5});
        assertNotNull(elements);
    }

    @Test
    public void flatten_flat_one_level_array()  {
        int[] flatten = CommonJDK8Utils.flatten(new Object[]{1, new int[]{2}, 3, 4});
        System.out.println(Arrays.toString(flatten));
    }

    @Test
    public void flattenDepth_flatten_to_specified_depth()  {
        Object[] input = {
                1,
                new Object[]{2},
                new Object[]{
                        new Object[]{
                                new Object[]{
                                        3
                                },
                                4
                        }, 5
                }
        };

        Object[] flatten = CommonJDK8Utils.flattenDepth(input, 2);
        assertEquals(flatten,new Object[]{1, 2, new Object[]{3}, 4, 5});
    }

    @Test
    public void group_elements_by_length()  {
        Map<Integer, List<String>> groups = CommonJDK8Utils.groupBy(new String[]{"one", "two", "three"}, String::length);
        System.out.println(groups.get(0));
        System.out.println(groups.get(1));

    }

    @Test
    public void initial_return_array_except_last_element() {
        Integer[] initial = CommonJDK8Utils.initial(new Integer[]{1, 2, 3});
        assertEquals(initial,new Integer[]{1, 2});
    }

    @Test
    public void initializeArrayWithRange_from_1_to_5()  {
        int[] numbers = CommonJDK8Utils.initializeArrayWithRange(5, 1);
        System.out.println(Arrays.toString(numbers));
    }

    @Test
    public void initializeArrayWithValues()  {
        int[] elements = CommonJDK8Utils.initializeArrayWithValues(5, 2);
        System.out.println(Arrays.toString(elements));
    }

    @Test
    public void intersection_between_two_arrays()  {
        int[] elements = CommonJDK8Utils.intersection(new int[]{1, 2, 3}, new int[]{4, 3, 2});
        System.out.println(Arrays.toString(elements));
    }

    @Test
    public void isSorted_return_1_when_array_sorted_is_ascending_order()  {
        int sorted = CommonJDK8Utils.isSorted(new Integer[]{0, 1, 2, 3});
        assertEquals(sorted,1);

        sorted = CommonJDK8Utils.isSorted(new Integer[]{0, 1, 2, 2});
        assertEquals(sorted,1);
    }

    @Test
    public void isSorted_return_minus_1_when_array_sorted_in_descending_order()  {
        int sorted = CommonJDK8Utils.isSorted(new Integer[]{3, 2, 1, 0});
        assertEquals(sorted,-1);

        sorted = CommonJDK8Utils.isSorted(new Integer[]{3, 3, 2, 1, 0});
        assertEquals(sorted,-1);
    }

    @Test
    public void isSorted_returns_0_when_array_is_not_sorted()  {
        int sorted = CommonJDK8Utils.isSorted(new Integer[]{3, 4, 1, 0});
        assertEquals(sorted,0);
    }

    @Test
    public void join_should_create_string_from_an_array_with_different_sep_and_end()  {
        String joined = CommonJDK8Utils.join(new String[]{"pen", "pineapple", "apple", "pen"}, ",", "&");
        assertEquals(joined,"pen,pineapple,apple&pen");
    }

    @Test
    public void join_should_create_string_from_an_array_with_sep_only()  {
        String joined = CommonJDK8Utils.join(new String[]{"pen", "pineapple", "apple", "pen"}, ",");
        assertEquals(joined,"pen,pineapple,apple,pen");
    }

    @Test
    public void join_should_create_string_from_an_array_with_default_sep()  {
        String joined = CommonJDK8Utils.join(new String[]{"pen", "pineapple", "apple", "pen"});
        assertEquals(joined,"pen,pineapple,apple,pen");
    }

    @Test
    public void join_should_create_empty_string_with_empty_array()  {
        String joined = CommonJDK8Utils.join(new String[]{});
        assertEquals(joined,"");
    }

    @Test
    public void nthElement_return_nth_element_from_start_when_n_is_greater_than_0()  {
        String nthElement = CommonJDK8Utils.nthElement(new String[]{"a", "b", "c"}, 1);
        assertEquals(nthElement,"b");
    }


    @Test
    public void nthElement_return_nth_element_from_end_when_n_is_less_than_0()  {
        String nthElement = CommonJDK8Utils.nthElement(new String[]{"a", "b", "c"}, -3);
        assertEquals(nthElement,"a");
    }

    @Test
    public void pick_should_pick_key_pairs_corresponding_to_keys()  {
        Map<String, Integer> obj = new HashMap<>();
        obj.put("a", 1);
        obj.put("b", 2);
        obj.put("c", 3);

        Map<String, Integer> picked = CommonJDK8Utils.pick(obj, new String[]{"a", "c"});
        System.out.println(picked);
    }

    @Test
    public void reducedFilter_Test()  {
        Map<String, Object> item1 = new HashMap<>();
        item1.put("id", 1);
        item1.put("name", "john");
        item1.put("age", 24);

        Map<String, Object> item2 = new HashMap<>();
        item2.put("id", 2);
        item2.put("name", "mike");
        item2.put("age", 50);

        Map<String, Object>[] filtered = CommonJDK8Utils.reducedFilter(new Map[]{item1, item2}, new String[]{"id", "name"}, item -> (Integer) item.get("age") > 24);
        System.out.println(Arrays.toString(filtered));
    }

    @Test
    public void sample_should_return_random_element()  {
        Integer sample = CommonJDK8Utils.sample(new Integer[]{3, 7, 9, 11});
        System.out.println(sample);
    }

    @Test
    public void sampleSize_should_return_sample_of_size_array_length_when_sample_size_is_greater_than_array_size()  {
        Integer[] sample = CommonJDK8Utils.sampleSize(new Integer[]{1, 2, 3}, 4);
        System.out.println(Arrays.toString(sample));
    }

    @Test
    public void similarity_test()  {
        Integer[] arr = CommonJDK8Utils.similarity(new Integer[]{1, 2, 3}, new Integer[]{1, 2, 4});
        assertEquals(arr,new Integer[]{1, 2});
    }

    @Test
    public void empty_array()  {
        String[] empty = CommonJDK8Utils.emptyArray(String.class);
        assertNotNull(empty);
    }

    @Test
    public void sortedIndex_descending()  {
        int index = CommonJDK8Utils.sortedIndex(new Integer[]{5, 3, 2, 1}, 4);
        assertEquals(index,1);
    }

    @Test
    public void sortedIndex_ascending()  {
        int index = CommonJDK8Utils.sortedIndex(new Integer[]{30, 50}, 40);
        assertEquals(index,1);
    }

    @Test
    public void sortedIndex_ascending_at_end()  {
        int index = CommonJDK8Utils.sortedIndex(new Integer[]{30, 50}, 60);
        assertEquals(index,2);
    }

    @Test
    public void symmetricDifference_test()  {
        Integer[] diff = CommonJDK8Utils.symmetricDifference(
                new Integer[]{1, 2, 3},
                new Integer[]{1, 2, 4}
        );
        assertEquals(diff,new Integer[]{3, 4});
    }

    @Test
    public void union_test()  {
        Integer[] union = CommonJDK8Utils.union(
                new Integer[]{1, 2, 3},
                new Integer[]{1, 2, 4}
        );

        assertEquals(union,new Integer[]{1, 2, 3, 4});
    }

    @Test
    public void without_test()  {
        Integer[] without = CommonJDK8Utils.without(
                new Integer[]{2, 1, 2, 3},
                1, 2

        );

        assertEquals(without,new Integer[]{3});
    }

    @Test
    public void zip_test()  {
        List<Object[]> zipped = CommonJDK8Utils.zip(
                new String[]{"a", "b"},
                new Integer[]{1, 2},
                new Boolean[]{true, false}
        );
        System.out.println(zipped);
    }

    @Test
    public void zip_test_2()  {
        List<Object[]> zipped = CommonJDK8Utils.zip(
                new String[]{"a"},
                new Integer[]{1, 2},
                new Boolean[]{true, false}
        );

        assertTrue(zipped.size()==2);
        assertEquals(zipped.get(0),new Object[]{"a", 1, true});
        assertEquals(zipped.get(1),new Object[]{null, 2, false});
    }

    @Test
    public void zipObject_test_1()  {
        Map<String, Object> map = CommonJDK8Utils.zipObject(
                new String[]{"a", "b", "c"},
                new Integer[]{1, 2}
        );
        System.out.println(map);

    }

    @Test
    public void zipObject_test_2() {
        Map<String, Object> map = CommonJDK8Utils.zipObject(
                new String[]{"a", "b"},
                new Integer[]{1, 2, 3}
        );
        System.out.println(map);
    }

    @Test
    public void average_of_1_to_10_is_5_dot_5()  {
        double average = CommonJDK8Utils.average(IntStream.rangeClosed(1, 10).toArray());
        assertEquals(average,5.5,0);
    }

    @Test
    public void capitalize_test()  {
        assertEquals(CommonJDK8Utils.capitalize("fooBar", false),"FooBar");
        assertEquals(CommonJDK8Utils.capitalize("fooBar", true),"Foobar");
    }

    @Test
    public void capitalizeEveryWord_test()  {
        assertEquals(CommonJDK8Utils.capitalizeEveryWord("hello world!"),"Hello World!");
    }

    @Test
    public void anagrams_test()  {
        List<String> anagrams = CommonJDK8Utils.anagrams("abc");
        assertTrue(anagrams.contains("cba"));
    }

    @Test
    public void byteSize_of_smiley_is_4()  {
        int length = CommonJDK8Utils.byteSize("\uD83D\uDE00");
        assertEquals(length,4);
    }

    @Test
    public void byteSize_of_hello_world_is_11()  {
        assertEquals(CommonJDK8Utils.byteSize("Hello World"),11);
    }

    @Test
    public void countVowels_test()  {
        assertEquals(CommonJDK8Utils.countVowels("foobar"),3);
    }

    @Test
    public void escapeRegex_test()  {
        assertEquals(CommonJDK8Utils.escapeRegExp("(test)"),"\\Q(test)\\E");
    }

    @Test
    public void fromCamelCase_test()  {
        assertEquals(CommonJDK8Utils.fromCamelCase("someJavaProperty", "_"),"some_java_property");
        assertEquals(CommonJDK8Utils.fromCamelCase("someDatabaseFieldName", " "),"some database field name");
        assertEquals(CommonJDK8Utils.fromCamelCase("someLabelThatNeedsToBeCamelCased", "-"),"some-label-that-needs-to-be-camelized");
    }

    @Test
    public void isAbsoluteUrl_test()  {
        assertTrue(CommonJDK8Utils.isAbsoluteUrl("https://google.com"));
        assertTrue(CommonJDK8Utils.isAbsoluteUrl("ftp://www.myserver.net"));
        assertFalse(CommonJDK8Utils.isAbsoluteUrl("/foo/bar"));
    }

    @Test
    public void isLowerCase_test()  {
        assertTrue(CommonJDK8Utils.isLowerCase("abc"));
        assertTrue(CommonJDK8Utils.isLowerCase("a3@$"));
        assertFalse(CommonJDK8Utils.isLowerCase("Ab4"));
    }

    @Test
    public void mask_test()  {
        assertEquals(CommonJDK8Utils.mask("1234567890", 4, "*"),"******7890");
        assertEquals(CommonJDK8Utils.mask("1234567890", 3, "*"),"*******890");
        assertEquals(CommonJDK8Utils.mask("1234567890", -4, "*"),"1234******");
    }

    @Test
    public void palindrome_test()  {
        assertTrue(CommonJDK8Utils.isPalindrome("taco cat"));
        assertFalse(CommonJDK8Utils.isPalindrome("abc"));
    }

    @Test
    public void reverseString_test()  {
        assertEquals(CommonJDK8Utils.reverseString("foobar"),"raboof");
    }

    @Test
    public void sortCharactersInString_test()  {
        assertEquals(CommonJDK8Utils.sortCharactersInString("cabbage"),"aabbceg");
    }

    @Test
    public void splitLines_test()  {
        System.out.println(CommonJDK8Utils.splitLines("This\nis a\nmultiline\nstring.\n"));
    }

    @Test
    public void toCamelCase_test()  {
        assertEquals(CommonJDK8Utils.toCamelCase("some_database_field_name"),"someDatabaseFieldName");
        assertEquals(CommonJDK8Utils.toCamelCase("Some label that needs to be camelized"),"someLabelThatNeedsToBeCamelized");
        assertEquals(CommonJDK8Utils.toCamelCase("some-java-property"),"someJavaProperty");
        assertEquals(CommonJDK8Utils.toCamelCase("some-mixed_string with spaces_underscores-and-hyphens"),"someMixedStringWithSpacesUnderscoresAndHyphens");
    }

    @Test
    public void toKebabCase_test()  {
        assertEquals(CommonJDK8Utils.toKebabCase("camelCase"),"camel-case");
        assertEquals(CommonJDK8Utils.toKebabCase("some text"),"some-text");
        assertEquals(CommonJDK8Utils.toKebabCase("some-mixed_string With spaces_underscores-and-hyphens"),"some-mixed-string-with-spaces-underscores-and-hyphens");
        assertEquals(CommonJDK8Utils.toKebabCase("AllThe-small Things"),"all-the-small-things");
        assertEquals(CommonJDK8Utils.toKebabCase("IAmListeningToFMWhileLoadingDifferentURLOnMyBrowserAndAlsoEditingXMLAndHTML"),"i-am-listening-to-fm-while-loading-different-url-on-my-browser-and-also-editing-xml-and-html");
    }

    @Test
    public void toSnakeCase_test()  {
        assertEquals(CommonJDK8Utils.toSnakeCase("camelCase"),"camel_case");
        assertEquals(CommonJDK8Utils.toSnakeCase("some text"),"some_text");
        assertEquals(CommonJDK8Utils.toSnakeCase("some-mixed_string With spaces_underscores-and-hyphens"),"some_mixed_string_with_spaces_underscores_and_hyphens");
        assertEquals(CommonJDK8Utils.toSnakeCase("AllThe-small Things"),"all_the_small_things");
        assertEquals(CommonJDK8Utils.toSnakeCase("IAmListeningToFMWhileLoadingDifferentURLOnMyBrowserAndAlsoEditingXMLAndHTML"),"i_am_listening_to_fm_while_loading_different_url_on_my_browser_and_also_editing_xml_and_html");
    }

    @Test
    public void truncateString_test()  {
        assertEquals(CommonJDK8Utils.truncateString("boomerang", 7),"boom...");
    }

    @Test
    public void words_test()  {
        assertEquals(CommonJDK8Utils.words("I love java!!"),new String[]{"I", "love", "java"});
        assertEquals(CommonJDK8Utils.words("Kotlin, Java & LemonTea"),new String[]{"Kotlin", "Java", "LemonTea"});
    }

    @Test
    public void randomInts_test()  {
        System.out.println(Arrays.stream(CommonJDK8Utils.randomInts(5, 100, 200)));
    }

    @Test
    public void concat_test()  {
        String[] first = {"a", "b"};
        String[] second = {"c", "d"};
        System.out.println(Arrays.toString(CommonJDK8Utils.concat(first, second)));
    }

    @Test
    public void getCurrentWorkingDirectoryPath_test()  {
        System.out.println(CommonJDK8Utils.getCurrentWorkingDirectoryPath());
    }

    @Test
    public void isNumeric_test()  {
        assertTrue(CommonJDK8Utils.isNumeric("123"));
        assertFalse(CommonJDK8Utils.isNumeric("abc"));
        assertFalse(CommonJDK8Utils.isNumeric(""));
    }

    @Test
    public void findNextPositivePowerOfTwo_test()  {
        assertEquals(CommonJDK8Utils.findNextPositivePowerOfTwo(-1),1);
        assertEquals(CommonJDK8Utils.findNextPositivePowerOfTwo(3),4);
        assertEquals(CommonJDK8Utils.findNextPositivePowerOfTwo(31),32);
        assertEquals(CommonJDK8Utils.findNextPositivePowerOfTwo(32),32);
    }

    @Test
    public void isEven_test()  {
        assertFalse(CommonJDK8Utils.isEven(1));
        assertTrue(CommonJDK8Utils.isEven(2));
        assertFalse(CommonJDK8Utils.isEven(3));
        assertTrue(CommonJDK8Utils.isEven(4));
        assertFalse(CommonJDK8Utils.isEven(-1));
    }

    @Test
    public void stringToIntegers_test()  {
        int[] intArray = CommonJDK8Utils.stringToIntegers("1 2 3 4 5");
        System.out.println(Arrays.toString(intArray));
    }

    private static class Class1 implements I2, I1, I5 {
        // empty
    }

    private static class Class2 extends Class1 implements I2, I3 {
        // empty
    }

    private interface I1 {
        // empty
    }

    private interface I2 {
        // empty
    }

    private interface I3 extends I4, I5 {
        // empty
    }

    private interface I4 {
        // empty
    }

    private interface I5 extends I6 {
        // empty
    }

    private interface I6 {
        // empty
    }

    @Test
    public void getAllInterfaces_shouldFindAllInterfacesImplementedByAClass() {
        final List<Class<?>> list = CommonJDK8Utils.getAllInterfaces(Class2.class);
        assertEquals(6, list.size());
    }

    enum Priority {
        High, Medium, Low
    }

    @Test
    public void getEnumMap_convert_enum_to_map()  {
        Map<String, Priority> map = CommonJDK8Utils.getEnumMap(Priority.class);
        assertEquals(3, map.size());
    }
}
