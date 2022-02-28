package ben.anzo.walletfinal;

import android.util.JsonWriter;

import java.io.IOException;
import java.io.Writer;

public class WriteInJSon {
    public static void writeJsonStream(Writer output, Account account ) throws IOException {
        JsonWriter jsonWriter = new JsonWriter(output);

        jsonWriter.beginObject();

        jsonWriter.name("Comptes").beginArray().beginObject();
        jsonWriter.name("type_de_compte").value(account.accounttype);
        jsonWriter.name("Date").value(account.date);
        jsonWriter.name("Solde").value(account.money);

        jsonWriter.name("Comptes").endObject().endArray();
        jsonWriter.endObject();
    }
}
