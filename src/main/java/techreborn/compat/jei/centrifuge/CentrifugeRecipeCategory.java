package techreborn.compat.jei.centrifuge;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.BlankRecipeCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.translation.I18n;
import techreborn.compat.jei.RecipeCategoryUids;
import techreborn.compat.jei.RecipeUtil;

import javax.annotation.Nonnull;

public class CentrifugeRecipeCategory extends BlankRecipeCategory<CentrifugeRecipeWrapper> {
	public static final ResourceLocation texture = new ResourceLocation("techreborn", "textures/gui/jei.png");
	private static final int[] INPUT_SLOTS = { 0, 1 };
	private static final int[] OUTPUT_SLOTS = { 2, 3, 4, 5 };
	private final IDrawable background;
	private final String title;

	public CentrifugeRecipeCategory(IGuiHelper guiHelper) {
		background = guiHelper.createDrawable(texture, 0, 0, 104, 62);
		title = I18n.translateToLocal("tile.techreborn.centrifuge.name");
	}

	@Nonnull
	@Override
	public String getUid() {
		return RecipeCategoryUids.CENTRIFUGE;
	}

	@Nonnull
	@Override
	public String getTitle() {
		return title;
	}

	@Nonnull
	@Override
	public IDrawable getBackground() {
		return background;
	}

	@Override
	public void setRecipe(
		@Nonnull
			IRecipeLayout recipeLayout,
		@Nonnull
			CentrifugeRecipeWrapper recipeWrapper,
		@Nonnull
			IIngredients ingredients) {
		IGuiItemStackGroup guiItemStacks = recipeLayout.getItemStacks();
		guiItemStacks.init(INPUT_SLOTS[0], true, 3, 12);
		guiItemStacks.init(INPUT_SLOTS[1], true, 3, 32);

		guiItemStacks.init(OUTPUT_SLOTS[0], false, 45, 22);
		guiItemStacks.init(OUTPUT_SLOTS[1], false, 64, 3);
		guiItemStacks.init(OUTPUT_SLOTS[2], false, 83, 22);
		guiItemStacks.init(OUTPUT_SLOTS[3], false, 64, 41);

		RecipeUtil.setRecipeItems(recipeLayout, ingredients, INPUT_SLOTS, OUTPUT_SLOTS, null, null);
	}
}
