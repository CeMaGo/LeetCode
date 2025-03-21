import java.util.*;

class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> recipeMap = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();
        Set<String> supplySet = new HashSet<>(Arrays.asList(supplies));

        for(int i = 0; i < recipes.length; i++) {
            recipeMap.put(recipes[i], ingredients.get(i));
            inDegree.put(recipes[i], ingredients.get(i).size());
        }

        Queue<String> queue = new LinkedList<>();
        for(String supply : supplies) {
            queue.offer(supply);
        }

        List<String> result = new ArrayList<>();
        while(!queue.isEmpty()) {
            String ingredient = queue.poll();
            for (String recipe : recipes) {
                if (recipeMap.containsKey(recipe)) {
                    List<String> recipeIngredients = recipeMap.get(recipe);
                    if (recipeIngredients.contains(ingredient)) {
                        inDegree.put(recipe, inDegree.get(recipe) -1);
                        if ( inDegree.get(recipe) == 0) {
                            result.add(recipe);
                            queue.offer(recipe);
                         }
                    }
                }
            }
        }
        return result;
    }
}