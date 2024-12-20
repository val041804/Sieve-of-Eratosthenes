public class Main {
    static void fill_multiples(boolean[] is_composite, int base_k){
        for(int i = base_k*2; i < is_composite.length; i+=base_k){
            is_composite[i] = true;
        }
    }

    static int[] prime_sieve(int k){
        boolean[] is_composite = new boolean[k+1];
        int base_k = 2; // base case
        int prime_count = 1;

        is_composite[0] = true; // while not actually true, 0 and 1 are neither prime nor composite,
        is_composite[1] = true; // this allows us to exclude it from the list of primes easily.

        for(int i = 2; i <= k; i++){
            fill_multiples(is_composite, base_k);
            for(int j = base_k; j <= k; j++){
                if(!is_composite[j] && j != base_k) {
                    base_k = j;
                    prime_count++;
                    break;
                }
            }
        }

        int[] primes = new int[prime_count];
        for(int i = 0, j = 0; i < is_composite.length; i++){
            if(!is_composite[i]) {
                primes[j] = i;
                j++;
            }
        }

        return primes;
    }

    public static void main(String[] args) {
        int[] k_primes = prime_sieve(10);
        for (int kPrime : k_primes) {
            System.out.print(kPrime + " ");
        }
    }
}