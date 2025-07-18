<h2><a href="https://leetcode.com/problems/convert-json-string-to-object">2851. Convert JSON String to Object</a></h2><h3>Hard</h3><hr><p>Given a string <code>str</code>, return parsed JSON&nbsp;<code>parsedStr</code>.&nbsp;You may assume the <code>str</code>&nbsp;is a valid JSON string hence it only includes strings, numbers, arrays, objects, booleans, and null. <code>str</code>&nbsp;will not include invisible characters and escape characters.&nbsp;</p>

<p>Please solve it without using the built-in&nbsp;<code>JSON.parse</code>&nbsp;method.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> str = &#39;{&quot;a&quot;:2,&quot;b&quot;:[1,2,3]}&#39;
<strong>Output:</strong> {&quot;a&quot;:2,&quot;b&quot;:[1,2,3]}
<strong>Explanation:</strong>&nbsp;Returns the object represented by the JSON string.</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> str = &#39;true&#39;
<strong>Output:</strong> true
<strong>Explanation:</strong> Primitive types are valid JSON.</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> str = &#39;[1,5,&quot;false&quot;,{&quot;a&quot;:2}]&#39;
<strong>Output:</strong> [1,5,&quot;false&quot;,{&quot;a&quot;:2}]
<strong>Explanation:</strong> Returns the array represented by the JSON string.</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>str</code> is a valid JSON string</li>
	<li><code>1 &lt;= str.length &lt;= 10<sup>5</sup></code></li>
</ul>
