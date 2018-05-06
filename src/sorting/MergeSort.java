package sorting;

public class  MergeSort     {

	private static Comparable<?>[] aux;

	public static void merge(Comparable<?>[] a, int lo, int mid, int hi) { // Merge a[lo..mid] with a[mid+1..hi].

		int i = lo, j = mid + 1;

		for (int k = lo; k <= hi; k++)
			aux[k] = a[k];

		for (int k = lo; k <= hi; k++) // Merge
			if (i > mid)						a[k] = aux[j++];
			else if (j > hi)					a[k] = aux[i++];
			else if (less(aux[j], aux[i]))		a[k] = aux[j++];
			else								a[k] = aux[i++];
	}
	
	public static void sort(Comparable<?>[] a) {
		aux = new Comparable[a.length];
		// Allocate space just once.
		sort(a, 0, a.length - 1);
	}
	
	private static void sort(Comparable<?>[] a, int lo, int hi) {
		if (hi <= lo)
			return;
		int mid = lo + (hi - lo) / 2;
		sort(a, lo, mid);
		// Sort left half.
		sort(a, mid + 1, hi);
		// Sort right half.
		merge(a, lo, mid, hi); // Merge results (code on page 271).
	}

	private static boolean less(Comparable<?> c1, Comparable<?> c2) {
		// TODO Auto-generated method stub
		return false;
	}
}
