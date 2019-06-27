// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: message_type.proto

package com.smart.im.protocal.proto;

public final class MessageTypeEntity {
  private MessageTypeEntity() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  /**
   * Protobuf enum {@code MessageType}
   */
  public enum MessageType
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <pre>
     * 文本
     * </pre>
     *
     * <code>TXT = 0;</code>
     */
    TXT(0),
    /**
     * <pre>
     * 表情
     * </pre>
     *
     * <code>EMOJI = 1;</code>
     */
    EMOJI(1),
    /**
     * <pre>
     * 图片
     * </pre>
     *
     * <code>PIC = 2;</code>
     */
    PIC(2),
    /**
     * <pre>
     * 音频
     * </pre>
     *
     * <code>AUDIO = 3;</code>
     */
    AUDIO(3),
    /**
     * <pre>
     * 视频
     * </pre>
     *
     * <code>VIDEO = 4;</code>
     */
    VIDEO(4),
    /**
     * <pre>
     * 文件
     * </pre>
     *
     * <code>FILE = 5;</code>
     */
    FILE(5),
    /**
     * <pre>
     * 分享
     * </pre>
     *
     * <code>SHARE = 6;</code>
     */
    SHARE(6),
    /**
     * <pre>
     * 新闻
     * </pre>
     *
     * <code>NEW = 7;</code>
     */
    NEW(7),
    UNRECOGNIZED(-1),
    ;

    /**
     * <pre>
     * 文本
     * </pre>
     *
     * <code>TXT = 0;</code>
     */
    public static final int TXT_VALUE = 0;
    /**
     * <pre>
     * 表情
     * </pre>
     *
     * <code>EMOJI = 1;</code>
     */
    public static final int EMOJI_VALUE = 1;
    /**
     * <pre>
     * 图片
     * </pre>
     *
     * <code>PIC = 2;</code>
     */
    public static final int PIC_VALUE = 2;
    /**
     * <pre>
     * 音频
     * </pre>
     *
     * <code>AUDIO = 3;</code>
     */
    public static final int AUDIO_VALUE = 3;
    /**
     * <pre>
     * 视频
     * </pre>
     *
     * <code>VIDEO = 4;</code>
     */
    public static final int VIDEO_VALUE = 4;
    /**
     * <pre>
     * 文件
     * </pre>
     *
     * <code>FILE = 5;</code>
     */
    public static final int FILE_VALUE = 5;
    /**
     * <pre>
     * 分享
     * </pre>
     *
     * <code>SHARE = 6;</code>
     */
    public static final int SHARE_VALUE = 6;
    /**
     * <pre>
     * 新闻
     * </pre>
     *
     * <code>NEW = 7;</code>
     */
    public static final int NEW_VALUE = 7;


    public final int getNumber() {
      if (this == UNRECOGNIZED) {
        throw new IllegalArgumentException(
            "Can't get the number of an unknown enum value.");
      }
      return value;
    }

    /**
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @Deprecated
    public static MessageType valueOf(int value) {
      return forNumber(value);
    }

    public static MessageType forNumber(int value) {
      switch (value) {
        case 0: return TXT;
        case 1: return EMOJI;
        case 2: return PIC;
        case 3: return AUDIO;
        case 4: return VIDEO;
        case 5: return FILE;
        case 6: return SHARE;
        case 7: return NEW;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<MessageType>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        MessageType> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<MessageType>() {
            public MessageType findValueByNumber(int number) {
              return MessageType.forNumber(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      return getDescriptor().getValues().get(ordinal());
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return MessageTypeEntity.getDescriptor().getEnumTypes().get(0);
    }

    private static final MessageType[] VALUES = values();

    public static MessageType valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      if (desc.getIndex() == -1) {
        return UNRECOGNIZED;
      }
      return VALUES[desc.getIndex()];
    }

    private final int value;

    private MessageType(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:MessageType)
  }


  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\022message_type.proto*^\n\013MessageType\022\007\n\003T" +
      "XT\020\000\022\t\n\005EMOJI\020\001\022\007\n\003PIC\020\002\022\t\n\005AUDIO\020\003\022\t\n\005V" +
      "IDEO\020\004\022\010\n\004FILE\020\005\022\t\n\005SHARE\020\006\022\007\n\003NEW\020\007B0\n\033" +
      "com.smart.im.protocal.protoB\021MessageType" +
      "Entityb\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
  }

  // @@protoc_insertion_point(outer_class_scope)
}