import com.google.gson.annotations.SerializedName

data class DemoModel(

	@SerializedName("id") val id: Int,
	@SerializedName("firstName") val firstName: String,
	@SerializedName("lastName") val lastName: String,
	@SerializedName("fullName") val fullName: String,
	@SerializedName("title") val title: String,
	@SerializedName("family") val family: String,
	@SerializedName("image") val image: String,
	@SerializedName("imageUrl") val imageUrl: String
)
