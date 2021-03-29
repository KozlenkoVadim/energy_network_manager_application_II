package network;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import network.model.Node;
import network.services.NetworkRepository;
import network.services.NetworkServices;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileAlreadyExistsException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

@Setter
@Getter
public class NetworkServicesImpl implements NetworkServices, NetworkRepository {
    private static final Logger LOGGER = Logger.getLogger(NetworkServicesImpl.class.toString());

    private Node network;

    @Override
    public void deleteNetwork(Node network) {
        network = null;
    }

    @Override
    public List<String> searchNetworks() {
        List<File> rezultList = new LinkedList<>();
        List<String> nameList = new LinkedList<>();
        fileSearch(new File(NetworkRepository.PATH_NAME), rezultList);
        for (File file : rezultList) {
            System.out.println(file.getName());
        }
        for (File file : rezultList) {
            nameList.add(file.getName());
        }
        return nameList;
    }

    private static void fileSearch(@NotNull File file, List<File> rezultList) {
        if (file.isDirectory()) {
            File[] directoryFiles = file.listFiles();
            if (directoryFiles != null) {
                for (File files : directoryFiles) {
                    if (files.isDirectory()) {
                        fileSearch(files, rezultList);
                    } else if (files.getName().toLowerCase().endsWith(".json")) {
                        rezultList.add(files);
                    }
                }
            }
        }
    }

    @Override
    public Node load(String fileName) throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream input = stream(NetworkRepository.PATH_NAME + fileName);
        try {
            network = objectMapper.readValue(input, Node.class);
        } catch (IllegalArgumentException e) {
            LOGGER.info("You entered an incorrect File name");
        }
        try {
            input.close();
        }catch (NullPointerException e){
            LOGGER.info("input is null");
        }
        return network;
    }

    @Override
    public void save(Node network, String name) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File(NetworkRepository.PATH_NAME + name), network);
        } catch (FileAlreadyExistsException e) {
            LOGGER.info("You entered a File name that all ready exist! ");
            //print("You entered a File name that all ready exist! ");
        } catch (IOException e) {
            LOGGER.info("You are doing some thing wrong! ");
            //print("You are doing some thing wrong! ");
        }
    }

    private static void print(String string) {
        System.out.println(string);
    }

    private static InputStream stream(String pathName) {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(pathName);
        } catch (IOException e) {
            LOGGER.info("Some things wrong with your stream, maybe your path is failure !");
            //print("Some things wrong with your stream, maybe your path is failure !");
        }
        return inputStream;
    }

    @Override
    public String toString() {
        return getNetwork().toString();
    }
}
