package ben.anzo.walletfinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

private static final int MENU_ITEM_VIEW_TYPE = 0;

private static  final int NATIVE_EXPRESS_AD_VIEW_TYPE = 1;

private final Context mcontext;

private  final List<Object> listRecyclerItem;

    public RecyclerAdapter(Context context, List<Object> listRecyclerItem) {
        this.mcontext = context;
        this.listRecyclerItem = listRecyclerItem;
    }
    public class ItemViewHolder extends RecyclerView.ViewHolder{
       private TextView money;
       private TextView type;
       private TextView date;
       private CircleImageView logo;
        public ItemViewHolder(View itemView){
            super(itemView);
            money = (TextView) itemView.findViewById(R.id.money);
            type = (TextView) itemView.findViewById(R.id.accountTyPe);
            date = (TextView) itemView.findViewById(R.id.dateofcreation);
            logo =(CircleImageView) itemView.findViewById(R.id.accountlogo);
        }
    }

    public class NativeExpressAdViewHolder extends RecyclerView.ViewHolder{

        NativeExpressAdViewHolder(View view){super(view);}

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        switch (i) {
            case MENU_ITEM_VIEW_TYPE:
            default:

               View layoutView = LayoutInflater.from(viewGroup.getContext()).inflate(
                        R.layout.list_model, viewGroup, false
                );
                return new ItemViewHolder((layoutView));
        }
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewholder, int i) {
int viewType = getItemViewType(i);
switch (viewType){
    case MENU_ITEM_VIEW_TYPE:
    default:
        ItemViewHolder itemViewHolder = (ItemViewHolder) viewholder;
    Account account = (Account) listRecyclerItem.get(i);

    String accountlog= account.getLogo();
  int imageResId = mcontext.getResources().getIdentifier(accountlog,"drawable",mcontext.getPackageName());

    itemViewHolder.money.setText(account.getMoney());
    itemViewHolder.date.setText(account.getDate());
    itemViewHolder.type.setText(account.getAccounttype());
 //   itemViewHolder.logo.setImageResource(Integer.valueOf(account.getLogo()));
}
    }

    @Override
    public int getItemCount() {
        return listRecyclerItem.size();
    }
}


