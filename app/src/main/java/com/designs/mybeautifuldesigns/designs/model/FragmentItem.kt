package com.designs.mybeautifuldesigns.designs.model

import androidx.annotation.ColorInt
import com.designs.mybeautifuldesigns.other.type.emptyBlock

/**
 * Created by Saidmurod Turdiyev (S.M.T) on 15/08/2022.
 */
data class FragmentItem(var name: String, @ColorInt val backgroundColor: Int, @ColorInt val textColor: Int, val openFragment: emptyBlock)
