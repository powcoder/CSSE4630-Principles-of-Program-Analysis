https://powcoder.com
代写代考加微信 powcoder
Assignment Project Exam Help
Add WeChat powcoder
https://powcoder.com
代写代考加微信 powcoder
Assignment Project Exam Help
Add WeChat powcoder
package string_sets;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * An implementation of a set of non-null strings.
 *
 * Uses a dense sorted array of strings, with binary search to find elements.
 * This is similar to TreeSet, but uses a single array of strings.
 * Add and remove can be slow, but contains is O(log N).
 *
 * @author Mark Utting, October 2020 for CSSE4630
 */
public class MySet0 extends AbstractSet<String>
{
	private ArrayList<String> contents = new ArrayList<String>();
	private int size = 0;

	public MySet0() {
		// a few internal tests of find
		/*
		contents.add("aa");
		contents.add("cc");
		size = 2;
		assert find("a") == 0;
		assert find("aa") == 0;
		assert find("b") == 1;
		assert find("cc") == 1;
		assert find("d") == 2;
		contents.clear();
		size = 0;
		*/
	}

	@Override
	public Iterator<String> iterator() {
		return contents.iterator();
	}

	@Override
	public int size() {
		return contents.size();
	}

	@Override
	public boolean contains(Object o) {
		if (o instanceof String) {
			String key = (String) o;
			int pos = find(key);
			// assert pos == contents.size() || key.equals(contents.get(pos)) == super.contains(o);
			return pos < contents.size() && key.equals(contents.get(pos));
		}
		return false;
	}

	/**
	 * Searches for the index of a given string.
	 *
	 * @param key any non-null string.
	 * @return The location at which 'key' should be inserted.
	 *    If it is already in the set, then this will be its current location.
	 *    Post: 0 <= result <= size
	 */
	private int find(String key) {
		int lo = 0;
		int hi = size;
		// invariant: 0 <= lo <= hi <= size
		// invariant: key in contents[lo ..< hi] else nowhere.
		// invariant: contents[size]==null (or off end).
		while (lo < hi) {
			int mid = (lo + hi)/2;
			int cmp = contents.get(mid).compareTo(key);
			if (cmp < 0) {
				lo = mid + 1;
			} else if (cmp == 0) {
				return mid;
			} else {
				hi = mid;
			}
		}
		return lo;
	}

	@Override
	public boolean add(String e) {
		if (e == null) {
			throw new NullPointerException();
		}
		int pos = find(e);
		if (pos < size && e.equals(contents.get(pos))) {
			return false;
		} else {
			// insert it at position pos
			contents.add(null);  // make room for it
			// assert contents.get(size) == null;
			for (int i = size; i > pos; i--) {
				contents.set(i, contents.get(i - 1));
			}
			contents.set(pos, e);
			size++;
			return true;
		}
	}

	@Override
	public boolean remove(Object o) {
		if (o instanceof String) {
			String e = (String) o;
			int pos = find(e);
			if (pos == size) {
				return false;
			} else {
				contents.remove(pos);
				size--;
				return true;
			}
		}
		return false;
	}
}
