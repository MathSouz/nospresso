package br.com.cwi.nespresso_app.presentation.component

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout

import android.content.res.TypedArray
import android.view.LayoutInflater
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.databinding.ComponentProductItemMenuBinding

class ProductItemConstraintLayout : ConstraintLayout {

    private var binding: ComponentProductItemMenuBinding =
        ComponentProductItemMenuBinding.inflate(LayoutInflater.from(context), this)


    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        context.obtainStyledAttributes(
            attrs,
            R.styleable.ProductItemConstraintLayout,
            defStyleAttr,
            0).run {
            binding.run {
                title = getString(
                    R.styleable.ProductItemConstraintLayout_component_product_item_menu_title
                )
                subtitle = getString(
                    R.styleable.ProductItemConstraintLayout_component_product_item_menu_subtitle
                )
                ivProductImage.setImageDrawable(
                    getDrawable(
                        R.styleable.ProductItemConstraintLayout_component_product_item_menu_image
                    )
                )
            }
            recycle()
        }
    }

    private var title: String? = null
        set(value) {
            field = value
            binding.tvProductTitle.text = value
        }

    private var subtitle: String? = null
        set(value) {
            field = value
            binding.tvProductSubtitle.text = value
        }
}